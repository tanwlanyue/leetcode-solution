package LC0040;

import java.util.*;

/**
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int length = candidates.length;
        if (length == 0) {
            return lists;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, path);
        return lists;
    }

    private void dfs(int[] candidates, int start, int target, LinkedList<Integer> path) {
        if (start >= candidates.length || target < 0) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            if (set.add(candidates[i])) {
                path.add(candidates[i]);
                if (target - candidates[i] == 0) {
                    lists.add(new ArrayList<>(path));
                }
                dfs(candidates, i + 1, target - candidates[i], path);
                path.removeLast();
            }
        }
    }
}