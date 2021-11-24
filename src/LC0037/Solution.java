package LC0037;

/**
 * @author zhanglei211 on 2021/11/24.
 */
class Solution {
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][] blockUsed = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    blockUsed[calBlock(i, j)][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private int calBlock(int i, int j) {
        int m = i / 3;
        int n = j / 3;
        return m * 3 + n;
    }

    private boolean dfs(char[][] board, int i, int j) {
        while (i < 9 && board[i][j] != '.') {
            i = j == 8 ? i + 1 : i;
            j = j == 8 ? 0 : j + 1;
        }
        if (i == 9) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if (rowUsed[i][num] || colUsed[j][num] || blockUsed[calBlock(i, j)][num]) {
                continue;
            }
            rowUsed[i][num] = true;
            colUsed[j][num] = true;
            blockUsed[calBlock(i, j)][num] = true;
            board[i][j] = (char) ('0' + num);
            if (dfs(board, i, j)) {
                return true;
            }
            board[i][j] = '.';
            rowUsed[i][num] = false;
            colUsed[j][num] = false;
            blockUsed[calBlock(i, j)][num] = false;
        }
        return false;
    }

}