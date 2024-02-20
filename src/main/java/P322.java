import java.util.Arrays;

public class P322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 完全背包版本
     */
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                if(j>=coins[i]){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        P322 p322 = new P322();
        int[] test = {1, 2, 5};
        System.out.println(p322.coinChange1(test, 7));
    }
}
