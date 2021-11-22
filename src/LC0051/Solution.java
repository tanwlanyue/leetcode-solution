package LC0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    ArrayList<List<String>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] table = new char[n][n];
        for (char[] chars : table) {
            Arrays.fill(chars,'.');
        }
        dfs(table, 0);
        return lists;
    }

    private void dfs(char[][] table, int i) {
        if (i == table.length) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : table) {
                StringBuilder builder = new StringBuilder();
                for (char aChar : chars) {
                    builder.append(aChar);
                }
                list.add(builder.toString());
            }
            lists.add(list);
            return;
        }
        for (int j = 0; j < table.length; j++) {
            table[i][j] = 'Q';
            if (check(table, i, j)) {
                dfs(table, i + 1);
            }
            table[i][j] = '.';
        }
    }

    private boolean check(char[][] table, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (table[k][j] == 'Q') {
                return false;
            }
        }
        int m = i - 1, n = j - 1;
        while (m >= 0 && n >= 0) {
            if (table[m][n] == 'Q') {
                return false;
            }
            m--;
            n--;
        }
        i = i - 1;
        j = j + 1;
        while (i >= 0 && j < table.length) {
            if (table[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}