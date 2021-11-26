package LC0017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    ArrayList<String> list = new ArrayList<>();
    char[][] chars = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        StringBuilder builder = new StringBuilder();
        if (digits.length() == 0) {
            return list;
        }
        dfs(digits, 0, builder);
        return list;
    }

    private void dfs(String digits, int i, StringBuilder builder) {
        if (i == digits.length()) {
            list.add(builder.toString());
            return;
        }
        int index = digits.charAt(i) - '2';
        for (char c : chars[index]) {
            builder.append(c);
            dfs(digits, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}