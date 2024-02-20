import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P93 {
    List<String> res = new ArrayList<>();

    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {;
        res.clear();
        backT(s, 0);
        return res;
    }

    public void backT(String s, int startIndex){
        if(startIndex>=s.length() && path.size() == 4){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if(i==path.size()-1){
                    stringBuilder.append(path.get(i));
                }else{
                    stringBuilder.append(path.get(i)).append(".");
                }
            }
            res.add(stringBuilder.toString());
            return;
        }

        char[] chars = s.toCharArray();
        for (int i = startIndex; i < chars.length; i++) {
            String subStr = s.substring(startIndex, i + 1);
            if(isOk(subStr)){
                path.add(subStr);
            }else{
                continue;
            }
            backT(s, i+1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isOk(String str){
        if(str.length()>1 && str.startsWith("0")) return false;
        if(str.length()>4) return false;
        return Integer.parseInt(str) <= 255;
    }

    public static void main(String[] args) {
        P93 p93 = new P93();
        System.out.println(p93.restoreIpAddresses("9999999999999999999"));
    }
}
