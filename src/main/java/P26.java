import java.util.Arrays;

public class P26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j] && j - i > 1) {
                // 此时中间有重复的元素了
                nums[++i] = nums[j];
            } else if (nums[i] != nums[j] && j - i == 1) {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                // i始终记录的是重复元素的第一个,但是覆盖的时候覆盖的是第二个,因为第一个要保留
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        P26 p26 = new P26();
        int[] test = {1,2,2,3,3,4,4,5};
        System.out.println(p26.removeDuplicates1(test));

    }
}
