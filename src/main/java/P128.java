import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        Set<Integer> data = new HashSet<>();
        for (int k : nums) {
            data.add(k);
        }
        int[] n_nums = data.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(n_nums);
        int temp_lx = 1;
        int max_lx = 1;
        for (int i = 1; i < n_nums.length; i++) {
            if (n_nums[i] - n_nums[i - 1] == 1) {
                temp_lx++;
                if (temp_lx > max_lx) {
                    max_lx = temp_lx;
                }
            } else {
                temp_lx = 1;
            }
        }
        return max_lx;
    }

    public static int longestConsecutive_yd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        Arrays.sort(nums);
        int temp_lx = 1;
        int max_lx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    temp_lx++;
                    if (temp_lx > max_lx) {
                        max_lx = temp_lx;
                    }
                } else {
                    temp_lx = 1;
                }
            }

        }
        return max_lx;
    }

    public static void main(String[] args) {
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        int i = longestConsecutive_yd(nums);
        System.out.println(i);
    }
}
