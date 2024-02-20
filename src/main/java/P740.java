import javax.management.MBeanAttributeInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P740 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果没有这个值就加入其值可对应的点数
            if(!dp.containsKey(nums[i])){
                dp.put(nums[i], nums[i]);
            }
            for(int j=0;j<nums.length;j++){
                if(nums[j] != nums[i]){

                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        P740 p740 = new P740();
        int[] test = {3,4,2};
        System.out.println(p740.deleteAndEarn(test));
    }
}
