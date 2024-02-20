import java.util.Arrays;

public class P41 {
    /**
     * 1. [0,1,2,3] 4
     * 2. [0,1,3,4] 2
     * 3. [0,1,4,6] 2
     */
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 大于0才去交换,小于0就放在这里先
            // 要交换的索引肯定要小于数组长度
            // 要交换的位置的值也不等于这个值，也就是这个值它没有放到正确的位置上的时候
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int a, int b) {
        if (a < 0 || b > nums.length - 1 || a > 0 || b < nums.length - 1) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        P41 p41 = new P41();
        int[] test = {3, 4, -1, 1};
        int[] test1 = {-4, -3, -1, 40, 43};
        int[] test2 = {1, 2, 0};
        int[] test3 = {1, 2, 6, 3, 5, 4};
        System.out.println(p41.firstMissingPositive(test1));
    }
}
