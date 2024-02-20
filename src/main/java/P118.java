import java.util.ArrayList;
import java.util.List;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        if(numRows<1) return res;
        if (numRows >= 1) res.add(new ArrayList<>() {{
            add(1);
        }});
        // 直接从1开始
        for (int i = 1; i < numRows; i++) {
            List<Integer> frontList = res.get(i - 1);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(frontList.get(j-1) + frontList.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        P118 p118 = new P118();
        List<List<Integer>> generate = p118.generate(3);
        System.out.println(generate);
    }
}
