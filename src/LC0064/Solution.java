package LC0064;

/**
 * @author zhanglei211 on 2021/10/14.
 * 问具体路径？
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for (int j = 1; j < col; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[0] = dp[0] + grid[i][0];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[col - 1];
    }
    // public int minPathSum(int[][] grid) {
    // int row = grid.length;
    // int col = grid[0].length;
    // int[][] dp = new int[row][col];
    // dp[0][0] = grid[0][0];
    // for (int i = 1; i < row; i++) {
    // dp[i][0] = dp[i - 1][0] + grid[i][0];
    // }
    // for (int j = 1; j < col; j++) {
    // dp[0][j] = dp[0][j - 1] + grid[0][j];
    // }
    // for (int i = 1; i < row; i++) {
    // for (int j = 1; j < col; j++) {
    // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
    // }
    // }
    // return dp[row - 1][col - 1];
    // }
}
