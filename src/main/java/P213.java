import java.util.Arrays;

public class P213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len<3) return Math.max(nums[0],nums[1]);

        // 起码是3个元素才开始执行下面的代码
        // 此时是不要最后一个元素
        int[] dp = new int[len-1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 此时是不要第一个元素
        int[] dp1 = new int[len-1];
        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[1], nums[2]);
        // 处理不要最后一个元素
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
//        System.out.println(Arrays.toString(dp));
        // 处理不要第一个元素
        for (int i = 3; i < nums.length; i++) {
            dp1[i-1] = Math.max(dp1[i-2], dp1[i-3] + nums[i]);
        }
//        System.out.println(Arrays.toString(dp1));

        return Math.max(dp[dp.length-1], dp1[dp1.length-1]);
    }


    public static void main(String[] args) {
        P213 p213 = new P213();
        int[] test = {1,2,1,1};
        System.out.println(p213.rob(test));
    }
}
