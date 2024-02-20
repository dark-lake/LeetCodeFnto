public class P746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        if (cost.length == 2) return Math.min(dp[0], dp[1]);
        for (int i = 2; i < cost.length; i++) {
            if (i == cost.length - 1) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
            }
        }
        return dp[cost.length - 1];
    }

    public int minCostClimbingStairs1(int[] cost) {
        // 我不理解的是为什么 + 1?
        // 这里的 最后一个代表的是楼顶,并不是最后一节台阶,而是跳到楼顶需要最小花费,此时需要用到
        // dp的最后一个台阶的值的
        // dp代表的是每一个台阶对应的最小花费
        int[] dp = new int[cost.length + 1];
        // 这里从0开始表示的是题干要求的0节和1节可以不花费,所以用0表示
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        P746 p746 = new P746();
        int[] test = {10, 15, 20};
        System.out.println(p746.minCostClimbingStairs1(test));
    }
}
