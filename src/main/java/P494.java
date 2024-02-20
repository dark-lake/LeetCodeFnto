import java.util.Arrays;

public class P494 {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1){
            if(Math.abs(target) == nums[0]){
                return 1;
            }
        }
        int sum = 0;
        // 求和sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
        if(Math.abs(target) > sum) return 0;
        if((target+sum)/2%2==1) return 0;
        // 定义dp
        int[] dp = new int[(target + sum)/2 + 1];
        // 初始化
        dp[0] = 1;
        // 从第一个开始
        for (int i = 0; i < nums.length; i++) {
            for (int j = (sum + target)/2 ; j >= nums[i]; j--) {
                // 求得组成dp[j]有几种组合的个数
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[(sum+target)/2];
    }

    public int findTargetSumWaysV1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        System.out.println(sum);
        // pos为小数||target绝对值比sum还大
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) return 0;
        int pos = (sum + target) / 2;
        int[] dp = new int[pos + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = pos; j >= num; j--) {
                dp[j] += dp[j - num];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[pos];
    }

    public static void main(String[] args) {
        P494 p494 = new P494();
        int[] test = {1,1,1,1,1};
        System.out.println(p494.findTargetSumWaysV1(test, 3));

    }
}
