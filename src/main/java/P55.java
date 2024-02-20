public class P55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1) return nums[0] == 0;
        for(int i=0;i<=cover;i++){
            cover = Math.max(cover, i + nums[i]);
            if(cover >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P55 p55 = new P55();
        int[] test = {4,2,0,0,1,1,4,4,4,0,4,0};
        System.out.println(p55.canJump(test));
    }
}
