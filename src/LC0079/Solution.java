package LC0079;

/**
 * @author zhanglei211 on 2021/11/5.
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean flag = dfs(board, word, i + 1, j, index + 1, row, col)
                || dfs(board, word, i - 1, j, index + 1, row, col) || dfs(board, word, i, j + 1, index + 1, row, col)
                || dfs(board, word, i, j - 1, index + 1, row, col);
        board[i][j] = temp;
        return flag;
    }
}