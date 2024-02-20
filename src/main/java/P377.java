import java.util.Arrays;

public class P377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 完全背包(一维)先遍历背包再遍历物品即可求得排列数
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i>=nums[j]) dp[i] += dp[i-nums[j]];
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static void main(String[] args) {
        P377 p377 = new P377();
        int[] test = {1,2,3};
        System.out.println(p377.combinationSum4(test, 4));
    }
}
