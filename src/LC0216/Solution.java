package LC0216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(1, 0, 0, k, n, path);
        return lists;
    }

    private void dfs(int start, int count, int sum, int k, int n, LinkedList<Integer> path) {
        if (sum >= n || count >= k) {
            if (sum == n && count == k) {
                lists.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(i + 1, count + 1, sum + i, k, n, path);
            path.removeLast();
        }
    }
}