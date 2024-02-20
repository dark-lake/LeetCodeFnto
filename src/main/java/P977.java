import java.util.Arrays;

public class P977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] res = new int[nums.length];
        while(left <= right){
            if(left == right){
                res[index] = nums[left];
            }
            if(nums[right] * nums[right] > nums[left] * nums[left]){
                res[index--] = nums[right] * nums[right];
                right--;
            }else{
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P977 p977 = new P977();
        int[] test = {-4};
        System.out.println(Arrays.toString(p977.sortedSquares1(test)));
    }
}
