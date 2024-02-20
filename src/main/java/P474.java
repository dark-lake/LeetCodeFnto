public class P474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 最多m个0, 最多n个1
        // dp[i][j]表示最多i个0,j个1的时候有多少个元素
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            // 统计这个str中的0和1的个数
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 这里虽然是二维的,但是还是当做一维的来看待,
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        P474 p474 = new P474();
        String[] test = {"10", "0001", "111001", "1", "0"};
        System.out.println(p474.findMaxForm(test, 5, 3));
    }
}
