public class P152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            dp[i] = nums[i];
            for (int j = i-1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[j] * temp);
                temp *= nums[j];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            dp[i] = nums[i];
            for (int j = i-1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] * temp);
                temp *= nums[j];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        P152 p152 = new P152();
        int[] test = {2,-1,1,1};
        int i = p152.maxProduct(test);
//        System.out.println(i);
    }
}
