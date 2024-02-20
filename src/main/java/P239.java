import java.util.Arrays;

public class P239 {
    // 这是暴力解法,超时,md
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int maxIndex = 1;
        // 这个长度是可以推出来的
        int[] max = new int[nums.length - k + 1];
        max[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                // 前k个
                max[0] = Math.max(nums[i], max[0]);
            } else {
                max[maxIndex] = nums[++left];
                for(int j=left+1;j<i+1;j++){
                    max[maxIndex] = Math.max(max[maxIndex], nums[j]);
                }
                maxIndex++;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        P239 p239 = new P239();
        int[] test = {1,-1};
        int[] ints = p239.maxSlidingWindow(test, 1);
        System.out.println(Arrays.toString(ints));
    }
}
