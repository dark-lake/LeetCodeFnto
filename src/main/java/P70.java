import java.util.Arrays;

public class P70 {
    public int climbStairs(int n) {
        if (n > 0 && n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs3(int n) {
        // 台阶表示背包容量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 完全背包的排列数, 因为先2后1和先1后2不一样
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= 3; j++) {
                // 遍历物品
                if(i>=j) dp[i] += dp[i-j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    /**
     * 就是climbStairs2的空间复杂度改进版
     * 发现每次其实只用到了最后的两个
     */
    public int climbStairs1(int n) {
        int i1 = 1, i2 = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = i1 + i2;
            i1 = i2;
            i2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        P70 p70 = new P70();
        int i = p70.climbStairs3(3);
        System.out.println(i);
    }
}
