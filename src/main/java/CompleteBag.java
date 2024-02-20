import java.util.Arrays;

public class CompleteBag {
    public int bag(int[] weight, int[] values, int bagRange) {
        // 唯一的不同是它是从前往后遍历 一维
        int[] dp = new int[bagRange + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[bagRange];
    }

    public int bag1(int[] weight, int[] values, int bagRange) {
        // 唯一的不同是它是从前往后遍历 一维
        int[] dp = new int[bagRange + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if(i >= weight[j]){
                    dp[i] = Math.max(dp[i], dp[i-weight[j]] + values[j]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[bagRange];
    }

    public static void main(String[] args) {
        CompleteBag completeBag = new CompleteBag();
        int[] weight = {1, 2, 4};
        int[] value = {15, 20, 25};
        System.out.println(completeBag.bag(weight, value, 4));
    }
}
