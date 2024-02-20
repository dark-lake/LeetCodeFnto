import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int sum;
        int left;
        int right;
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            sum = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int tempSum = nums[left] + nums[right];
                if(tempSum==sum){
                    List<Integer> tempRes = new ArrayList<>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[left]);
                    tempRes.add(nums[right]);
                    res.add(tempRes);
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }else if(tempSum > sum){
                    while(left < right && nums[right] == nums[--right]);
                }else{
                    while(left < right && nums[left] == nums[++left]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P15 p15 = new P15();

        System.out.println(Arrays.toString(new List[]{p15.threeSum(new int[]{-1,0,1,2,-1,-4})}));
    }
}
