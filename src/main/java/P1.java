import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 */
public class P1 {
    /**
     * 要求返回数组下标
     */
    public static int[] twoSum(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{};
        }

        if(nums.length<2){
            return new int[]{0};
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSum_hash(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{};
        }

        if(nums.length<2){
            return new int[]{0};
        }
        HashMap<Integer, Integer> data = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(data.containsKey(target-nums[i])){
                return new int[]{data.get(target-nums[i]), i};
            }
            data.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] data = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum_hash(data, 9)));
    }
}
