package LC0200;

import java.util.Objects;

/**
 * @author zhanglei211 on 2021/9/23.
 */
class Solution {
    // public int numIslands(char[][] grid) {
    // int row = grid.length;
    // int col = grid[0].length;
    // int count = 0;
    // String[][] parent = new String[row][col];
    //
    // for (int i = 0; i < row; i++) {
    // for (int j = 0; j < col; j++) {
    // if (grid[i][j] == '1') {
    // if(Objects.equals(parent[i][j],"")){
    // parent[i][j]=i+","+j;
    // }
    // union(parent, i, j, i + 1, j, row, col, grid);
    // union(parent, i - 1, j, i, j, row, col, grid);
    // union(parent, i, j, i, j + 1, row, col, grid);
    // union(parent, i, j - 1, i, j, row, col, grid);
    // }
    // }
    // }
    //
    // for (int i = 0; i < row; i++) {
    // for (int j = 0; j < col; j++) {
    // if (!Objects.equals(parent[i][j],"")) {
    // if(parent[i][j]!=i+","+j){
    // count++;
    // }
    // }
    // }
    // }
    // return count;
    // }
    //
    // public void union(String[][] parent, int i, int j, int m, int n, int row, int col, char[][] grid) {
    // if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
    // return;
    // }
    // if (m < 0 || m >= row || n < 0 || n >= col || grid[m][n] != '1') {
    // return;
    // }
    // String[] split = find(parent, m, n).split(",");
    // int pm = Integer.parseInt(split[0]);
    // int pn = Integer.parseInt(split[1]);
    // parent[pm][pn] = find(parent, i, j);
    // }
    //
    // public String find(String[][] parent, int i, int j) {
    // String[] split = parent[i][j].split(",");
    // int m = Integer.parseInt(split[0]);
    // int n = Integer.parseInt(split[1]);
    // if (m != i || j != n) {
    // return find(parent, m, n);
    // }
    // return parent[i][j];
    // }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i, j + 1, row, col);
        dfs(grid, i, j - 1, row, col);
    }
}