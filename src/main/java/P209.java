public class P209 {
    /**
     * 暴力解法, 注意开头就大于target和结尾就大于target的情况
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
            // 如果第一次也就是所有元素的和就小于target,直接返回0
            if (i == 0 && sum < target) {
                return 0;
            }
            if (i == nums.length - 1 && sum >= target) return 1;
        }
        return minLen;
    }


    /**
     * 滑动窗口解法
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(j - i + 1, minLen);
                sum -= nums[i++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        P209 p209 = new P209();
        int[] test = {1, 4, 4};
        System.out.println(p209.minSubArrayLen1(4, test));
    }
}
