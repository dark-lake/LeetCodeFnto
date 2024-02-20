import java.util.Arrays;

public class P27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        // 快慢指针法
        // 一开始慢指针和快指针一起前进,当快指针遇到val的时候慢指针就不走了
        // 直到快指针指的值不等于慢指针指的val的时候就把这个值覆盖掉慢指针的值,然后再一起往前走
        // 最后慢指正指的位置就是nums的长度.
        for(int i=0;i<nums.length;i++){
            if(val!=nums[i]){
                nums[slowIndex++] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return slowIndex;
    }

    public static void main(String[] args) {
        P27 p27 = new P27();
        int[] test = {1, 2, 3, 4, 4, 5, 6};
        System.out.println(p27.removeElement(test, 4));
    }
}
