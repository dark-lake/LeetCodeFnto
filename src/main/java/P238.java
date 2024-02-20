import java.util.Arrays;

public class P238 {
    /**
     * 可以但是时间超时
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    temp *= nums[j];
                    if (temp == 0) {
                        continue;
                    }
                }
            }
            result[i] = temp;
        }
        return result;
    }

    public int[] productExceptSelfV1(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        int temp = 1;
        // 前缀部分
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // 后缀部分
        for (int i = nums.length-2; i >= 0; i--) {
            temp *= nums[i+1];
            result[i] *= temp;
        }

        return result;
    }

    public static void main(String[] args) {
        P238 p238 = new P238();
        int[] data = {1,2,3,4};
        System.out.println(Arrays.toString(p238.productExceptSelfV1(data)));
    }
}
