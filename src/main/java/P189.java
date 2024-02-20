import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P189 {
    public static void rotate(int[] nums, int k) {

        if(nums.length < 2){
            return;
        }

        if(k>nums.length){
            k = k % nums.length;
        }

        reverse(nums, 0, nums.length-1);

        reverse(nums, 0, k-1);

        reverse(nums, k, nums.length-1);


    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] test = {-1,-100,3,99};
        rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }
}
