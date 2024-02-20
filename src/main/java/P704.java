public class P704 {
    public int search(int[] nums, int target) {
        // 这里就是向下取整
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;
        while (left <= right) {
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] > target){
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
                mid = (right + left) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        P704 p704 = new P704();
        System.out.println(p704.search(test, 7));
    }
}
