import java.util.Arrays;

public class P343 {
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[2] = 1;
        // 第一个就是1,无法拆分成2个正整数了, 从3开始,因为0,1没有值,2就是1
        for (int i = 3; i <= n; i++) {
            // 比较的时候为什么是 等于i/2,我也不会证明,i/2是一个的确正确的边界,但是实际要比较的是
            // dp[i-j]*j 比如 dp[5-2]*2 一定是大于 dp[5-3]*3, 如果证明不了这个那就无法说明为什么到i/2就不用
            // 算之后的了,当然也可以都算 既j<i
            for (int j = 1; j <= i/2; j++) {
                // 递推公式是难点
                // dp[i-j]*j算的是m个数的积,因为dp[i-j]表示的i-j的最大乘积,他可以多个数的积
                // (i-j)*j是两个数的积
                // 每次比较的都是两个数的积和多个数的积那个更大
                dp[i] = Math.max(Math.max(dp[i-j] * j, (i-j) * j), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P343 p343 = new P343();
        System.out.println(p343.integerBreak(10));

    }
}
