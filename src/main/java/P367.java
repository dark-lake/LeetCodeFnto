public class P367 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int res = -1;
        while (left <= right) {
            int mid = (left + right)>>1;
            int temp = mid * mid;
            if(temp<num){
                left = mid + 1;
            }else{
                res = mid;
                right = mid - 1;
            }
        }

        return res * res == num;
    }

    public static void main(String[] args) {
        P367 p367 = new P367();
        System.out.println(p367.isPerfectSquare(15));
    }
}
