package LC0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/2.
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        int total = n * 2;
        int leftSize = 0;
        int rightSize = 0;
        StringBuilder builder = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        dfs(builder, leftSize, rightSize, total, list);
        return list;
    }

    private void dfs(StringBuilder builder, int leftSize, int rightSize, int i, ArrayList<String> list) {
        if (i == 0) {
            if (leftSize == rightSize) {
                list.add(builder.toString());
            }
            return;
        }
        builder.append("(");
        dfs(builder, leftSize + 1, rightSize, i - 1, list);
        builder.deleteCharAt(builder.length() - 1);
        if (leftSize > rightSize) {
            builder.append(")");
            dfs(builder, leftSize, rightSize + 1, i - 1, list);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}