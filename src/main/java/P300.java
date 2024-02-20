import java.util.Arrays;

public class P300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P300 p300 = new P300();
        int[] test = {0,1,0,3,2,3};
        int i = p300.lengthOfLIS(test);
        System.out.println(i);
    }
}
