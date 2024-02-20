public class P69 {
    // 这是无赖
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    // 使用二分搜索来找
    public int mySqrt1(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while(left <= right){
            int mid = (left + right)>>1;
            long temp = (long) mid * mid;
            if(temp > x){
                right = mid - 1;
            }else if(temp < x){
                res = mid;
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P69 p69 = new P69();
        System.out.println(p69.mySqrt(0));
    }
}
