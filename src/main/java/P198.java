public class P198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        // 如果只偷第一家的那就是nums1
        dp[1] = nums[0];
        // 开始计算dp
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }

        return dp[length];
    }

    /**
     * 空间优化版本
     * 可以发现每次求dp[i]的时候只会用到dp[i-1]和dp[i-2]所以可以直接用两个变量来记录即可
     */
    public int robGood(int[] nums) {
        if (nums.length == 0) return 0;
        // 如果只偷第一家的那就是nums1
        int dp0 = 0, dp1 = nums[0];
        // 开始计算dp
        for (int i = 2; i <= nums.length; i++) {
            int temp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i-1]);
            dp0 = temp;
        }

        return dp1;
    }

    public int xxx(int[] nums){
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        P198 p198 = new P198();
        int[] test = {1, 2, 3, 1};
        System.out.println(p198.robGood(test));
    }
}
