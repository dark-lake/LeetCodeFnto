import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P904 {
    public int totalFruit(int[] fruits) {
        if(fruits.length<2) return fruits.length;
        // 滑动窗口
        int i = 1, k = 0;
        ArrayList<Integer> lz = new ArrayList<>();
        lz.add(fruits[0]);
        lz.add(-1);
        int res = Integer.MIN_VALUE;
        for (int j = 1; j < fruits.length; j++) {
            // 先处理种类数变化
            if (!lz.contains(fruits[j])) {
                if(lz.get(1) != -1) k++;
                lz.set(i++ % 2, fruits[j]);
            }
            // 再计算摘的个数
            res = Math.max(j - k + 1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        P904 p904 = new P904();
        int[] test = {1,1,2,2,3,4};
        System.out.println(p904.totalFruit(test));
    }
}
