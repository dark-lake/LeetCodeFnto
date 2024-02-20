import java.util.HashMap;
import java.util.Map;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            Integer orDefault = dic.getOrDefault(c, -1);
            if(orDefault!=-1){
                i = Math.max(orDefault, i);
            }
            dic.put(c, j);
            res = Math.max(res, j-i);
        }
        return res;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        System.out.println(p3.lengthOfLongestSubstring("abcabcbb"));
    }

}
