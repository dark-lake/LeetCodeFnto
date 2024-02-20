import java.util.Arrays;

public class P63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0: 1;
        // 如果第一个就是0那就直接结束了
        if(dp[0][0]==0) return 0;
        // 如果一共就一个,还不是0那就返回这个值
        if(m<2 & n<2) return dp[0][0];
        // 初始化下1和右1
        if (m > 1) dp[1][0] = obstacleGrid[1][0] == 1 ? 0 : 1;
        if (n > 1) dp[0][1] = obstacleGrid[0][1] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 此时这个点不是障碍
                if (obstacleGrid[i][j] != 1) {
                    // 此时上边和左边有可能是障碍,先不考虑障碍,先考虑是不是边
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else {
                        // 边节点,考虑它是行边还是列边
                        // 行边, 如果它的左边是障碍,那它就是0
                        if (i - 1 < 0 && j - 1 >= 0) {
                            dp[i][j] = dp[i][j - 1] == 0 ? 0 : 1;
                        }
                        // 0列
                        // 列边, 如果它的上边是障碍,那ta就是0
                        if (j - 1 < 0 && i - 1 >= 0) {
                            dp[i][j] = dp[i - 1][j] == 0 ? 0 : 1;
                        }
                    }
                } else {
                    // 如果这个点是障碍,那dp就是0
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        P63 p63 = new P63();
        int[][] test = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(p63.uniquePathsWithObstacles(test));

    }
}
