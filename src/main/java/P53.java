import java.util.ArrayList;
import java.util.Collections;

/**
 * 最大子数组和
 */
public class P53 {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if(dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
        }

        int max = dp[0];
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;

    }
    public static int maxSubArray_1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            System.out.println(i+"strat************************");
            System.out.println("count: " + count);
            if (count > res) res = count;
            System.out.println("res: " + res);
            if (count < 0) count = 0;
            System.out.println("count: " + count);
            System.out.println(i+"end************************");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray_1(data));
    }
}
