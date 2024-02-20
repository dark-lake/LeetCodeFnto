import java.util.HashMap;
import java.util.Map;

public class P560 {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> res = new HashMap<>();
        res.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (res.containsKey(sum - k)) {
                count += res.get(sum - k);
            }
            res.put(sum, res.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {
                result += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        P560 p560 = new P560();
        int[] test = {14,9,8,4,3,2};
        int k = 20;
        System.out.println(p560.subarraySum1(test, k));
    }
}
