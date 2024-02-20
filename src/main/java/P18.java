import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left, right;
        long sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                left = j + 1;
                right = nums.length - 1;
                sum = (long)target - (long)nums[i] - (long)nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 双指针开始
                while (left < right) {
                    int tempSum = nums[left] + nums[right];
                    if (tempSum == sum) {
                        List<Integer> tempRes = new ArrayList<>();
                        tempRes.add(nums[i]);
                        tempRes.add(nums[j]);
                        tempRes.add(nums[left]);
                        tempRes.add(nums[right]);
                        res.add(tempRes);
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (tempSum > sum) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else {
                        while (left < right && nums[left] == nums[++left]) ;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P18 p18 = new P18();
        int[] test = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(p18.fourSum(test, -294967296));
    }
}
