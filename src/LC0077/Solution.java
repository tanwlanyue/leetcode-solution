package LC0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n, k, list, 1);
        return res;
    }

    private void dfs(int n, int k, LinkedList<Integer> path, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, path, i + 1);
            path.removeLast();
        }
    }
}

