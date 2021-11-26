package LC0131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/24.
 */
class Solution {
    ArrayList<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        LinkedList<String> path = new LinkedList<>();
        dfs(s, 0, path);
        return lists;
    }

    private void dfs(String s, int start, LinkedList<String> path) {
        if (start == s.length()) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s, start, i)) {
                String substring = s.substring(start, i + 1);
                path.add(substring);
                dfs(s, i + 1, path);
                path.removeLast();
            }
        }
    }

    private boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}