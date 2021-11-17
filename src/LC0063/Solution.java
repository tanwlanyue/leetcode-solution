package LC0063;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : (j == 0 ? dp[j] : dp[j] + dp[j - 1]);
            }
        }
        return dp[col - 1];
    }
}