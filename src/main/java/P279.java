import java.util.Arrays;

public class P279 {
    public int numSquares(int n) {
        // 这道题还是挺难想的
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            // 这一步可以理解为全是1的情况
            dp[j] = j;
            for (int k = 1; j - k * k >= 0; k++) {
                // 这一步是不断是去比较,如果前一个j的平方和个数+1小于dp[j]那就用前一个的,
                dp[j] = Math.min(dp[j], dp[j - k * k] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 完全背包
     */
    public int numSquares1(int n) {
        // 这道题还是挺难想的
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i; j < dp.length; j++) {
                if (j - i * i >= 0) dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P279 p279 = new P279();
        System.out.println(p279.numSquares1(3));
    }
}
