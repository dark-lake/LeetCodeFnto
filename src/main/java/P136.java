import java.sql.SQLOutput;
import java.util.Arrays;

public class P136 {
    public int singleNumber(int[] nums) {
        if(nums.length < 2) return nums[0];
        // 先排序
        Arrays.sort(nums);
        // 第一个不等于第二个那就是第一个
        if(nums[0] != nums[1]) return nums[0];
        for (int k = 1; k < nums.length-1; k++) {
            // 既不等于前一个也不等于后一个
            if(nums[k]!=nums[k-1] && nums[k] != nums[k+1]) {
                return nums[k];
            }
        }
        // 都不等于就是最后一个
        return nums[nums.length-1];
    }

    public int test(int[] nums){
        int res = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            res = res ^ nums[i];
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        P136 p136 = new P136();
        int[] test = {2,2,1,4,4};
        int i = p136.test(test);
        System.out.println(i);
    }
}
