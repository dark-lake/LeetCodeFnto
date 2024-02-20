public class P62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        if(n>1) dp[0][1] = 1;
        if(m>1) dp[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当它有上节点和左结点的时候
                if(i-1>=0 && j-1>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    // 否则就是边节点直接为1即可
                    dp[i][j] = 1;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        P62 p62 = new P62();
        System.out.println(p62.uniquePaths(2, 3));
    }
}
