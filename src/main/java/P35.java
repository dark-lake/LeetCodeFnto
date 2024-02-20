public class P35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                // 等于
                return mid;
            }
            mid = (left + right) / 2;
        }
        return left;
    }

    public static void main(String[] args) {
        P35 p35 = new P35();
        int[] test = {1,3,5,6};
        System.out.println(p35.searchInsert(test, 5));
    }
}
