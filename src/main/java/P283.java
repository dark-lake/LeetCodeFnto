import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        Deque<Integer> zeroIndex = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {

                if (!zeroIndex.isEmpty()) {
                    int temp = nums[i];
                    nums[i] = 0;
                    Integer integer = zeroIndex.removeLast();
                    nums[integer] = temp;
                    zeroIndex.addFirst(i);
                }

            } else {
                zeroIndex.addFirst(i);
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        int n = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0){
                nums[n++] = nums[i];
            }
        }

        for(;n<len;n++){
            nums[n] = 0;
        }
    }

    public static void main(String[] args) {
        P283 p283 = new P283();
        int[] test = {0,1,0,3,12};
        int[] test1 = {0};
        p283.moveZeroes1(test);
        System.out.println(Arrays.toString(test));
    }
}
