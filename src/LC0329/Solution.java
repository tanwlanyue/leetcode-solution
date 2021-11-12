package LC0329;

/**
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {

    int row;
    int col;
    int[][] record;
    int maxLen = 0;

    public int longestIncreasingPath(int[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.record = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(matrix, i, j, -1);
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int pre) {
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= pre) {
            return 0;
        }
        if (record[i][j] != 0) {
            return record[i][j];
        }
        int a = dfs(matrix, i + 1, j, matrix[i][j]);
        int b = dfs(matrix, i - 1, j, matrix[i][j]);
        int c = dfs(matrix, i, j + 1, matrix[i][j]);
        int d = dfs(matrix, i, j - 1, matrix[i][j]);
        record[i][j] = 1 + Math.max(a, Math.max(b, Math.max(c, d)));
        maxLen = Math.max(maxLen, record[i][j]);
        return record[i][j];
    }
}