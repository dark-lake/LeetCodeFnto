public class P45 {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int cusD = 0;
        int count = 0;
        int nextD = 0;
        for (int i = 0; i < nums.length; i++) {
            nextD = Math.max(nums[i] + i,nextD);
            if(i == cusD){
                // 如果当前的覆盖范围已经走到头了
                count++;
                cusD = nextD;
                if(nextD >= nums.length - 1) break;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        P45 p45 = new P45();
        int[] test = {2,3,1,1,4,2,1};
        System.out.println(p45.jump(test));

    }
}
