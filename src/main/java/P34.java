import java.util.Arrays;

public class P34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MIN_VALUE;
        while (left <= right) {
            if (nums[left] == target) {
                res[0] = Math.min(left, res[0]);
            }
            if (nums[right] == target) {
                res[1] = Math.max(right, res[1]);
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                // 此时可能只有一个,刚好mid等于它
                res[0] = Math.min(res[0],mid);
                res[1] = Math.max(res[1],mid);
                left = left + 1;
                right = right - 1;
            }
            mid = (left + right) / 2;
        }
        if(res[0] == Integer.MAX_VALUE && res[1] == Integer.MIN_VALUE){
            return new int[]{-1,-1};
        }
        return res;
    }

    public static void main(String[] args) {
        P34 p34 = new P34();
        int[] test = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(p34.searchRange(test, 11)));
    }
}
