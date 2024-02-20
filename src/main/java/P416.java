import java.util.*;

public class P416 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        Map<Integer, Integer> res = new HashMap<>();
        res.put(0, 1);
        int tempSum = 0;
        int count = 0;
        // 求和
        for (int j : nums) sum += j;
        System.out.println(sum);
        // 求子数组中和为 sum/2是否存在, 如果sum/2是奇数那就不存在,因为奇数不可能等和
        if (sum % 2 == 1) return false;

        for (int num : nums) {
            tempSum += num;
            if (res.containsKey(tempSum - sum / 2)) {
                count += res.get(tempSum - sum / 2);
            }
            res.put(tempSum, res.getOrDefault(tempSum, 0) + 1);
        }
        System.out.println(count);
        return count != 0;
    }

    public boolean canPartitionV1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果是和是奇数,那肯定无法分成等和的两个数组
        if (sum % 2 == 1) return false;
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[0] > i ? 0 : nums[0];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < nums.length; i++) {
            // 这里要倒叙,每一个元素是不可重复放入的,所以从大到小遍历
            // 对于j<num[i]的默认其实就还是不加入这个值也就是之前的值
            // 这里为什么要从后往前,因为如果从前往后就会出现一个问题
            // 我们外层是遍历的当前的nums[i],如果前边已经用过这个nums[i]了后面会出现重复使用同一个值的问题
            // 但是如果从后往前遍历,每次的dp[j-nums[i]]里只包括nums[i]之前的nums的值,这样就保证了不会重复使用
            for (int j = sum/2; j >= nums[i]; j--) {
                // 此时不包含这个值
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        P416 p416 = new P416();
        int[] test = {1,2,5};
        System.out.println(p416.canPartitionV1(test));

    }
}
