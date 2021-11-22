package LC0130;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        for (int i = 0; i < col; i++) {
            if (board[top][i] == 'O') {
                dfs(board, top, i, row, col);
            }
            if (board[top][i] == 'O') {
                dfs(board, bottom, i, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][left] == 'O') {
                dfs(board, i, left, row, col);
            }
            if (board[i][right] == 'O') {
                dfs(board, i, right, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '@') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '@';
        dfs(board, i + 1, j, row, col);
        dfs(board, i - 1, j, row, col);
        dfs(board, i, j + 1, row, col);
        dfs(board, i, j - 1, row, col);
    }
}