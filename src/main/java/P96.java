import java.util.Arrays;

public class P96 {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    dp[i] += dp[i - 1];
                } else {
                    // k表示出去头结点还有几个节点
                    int k = i - 1;
                    // l表示当前的头结点是谁
                    int l = i - j;
                    // 对于中间的部分就是左边的节点个数的子树组合个数*右边节点个数的子树组合个数
                    dp[i] += dp[l] * dp[k-l];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P96 p96 = new P96();
        System.out.println(p96.numTrees(6));
    }
}
