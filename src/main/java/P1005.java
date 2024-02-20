import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Comparator;

public class P1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 按照绝对值排序
        Integer sum = 0;
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, (o1, o2) -> Math.abs(o2) - Math.abs(o1));
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] <= 0 && k > 0) {
                nums1[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1) nums1[nums1.length - 1] *= -1;
        for (Integer num : nums1) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        P1005 p1005 = new P1005();
        int[] test = {-2, 9, 9, 8, 4};
        System.out.println(p1005.largestSumAfterKNegations(test, 5));
    }
}

