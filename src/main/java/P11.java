public class P11 {
    public int maxArea(int[] height) {


        int length = height.length;
        int res = 0;
        int left = 0, right = length - 1;
        while(left<right){
            if(height[left] < height[right]){
                res = (right - left) * height[left++];
            }else{
                res = (right - left) * height[right--];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P11 p11 = new P11();
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(p11.maxArea(test));
    }
}
