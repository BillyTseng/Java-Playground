package come.eClass8_DP;

/**
 * 63. Unique Paths II - medium
 */

public class Q8_2_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        final int OBSTACLE = 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != OBSTACLE) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
