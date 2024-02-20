public class P376 {
    /**
     * 注意其中左边没有值的如果右边只有一个比它大那也算1个,同理最后一个如果左边有一个比他小那也算一个
     */
    public int wiggleMaxLength(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 1;
        for (int i = 0; i < nums.length -1; i++) {
            right = nums[i + 1] - nums[i];
            if((left>=0 && right<0) || (left<=0 && right>0)){
                res++;
                left = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P376 p376 = new P376();
        int[] test = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(p376.wiggleMaxLength(test));
    }
}
