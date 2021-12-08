package LC0036;

/**
 * 36. 有效的数独 <br/>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 <br/>
 * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 51.34% 的用户
 * 
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] bucket = new boolean[9][9];

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    if (row[i][num] || col[j][num] || bucket[calNum(i, j)][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[calNum(i, j)][num] = true;
                }

            }
        }
        return true;
    }

    private int calNum(int i, int j) {
        int m = i / 3;
        int n = j / 3;
        return m * 3 + n;
    }
}