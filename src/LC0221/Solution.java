package LC0221;

/**
 * @author zhanglei211 on 2021/9/21.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxEdge = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxEdge = Math.max(dp[i][j], maxEdge);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}