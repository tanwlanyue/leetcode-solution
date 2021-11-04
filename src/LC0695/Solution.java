package LC0695;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {

    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, row, col);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) {
            return;
        }
        count++;
        grid[i][j]=0;
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i, j + 1, row, col);
        dfs(grid, i, j - 1, row, col);
    }
}