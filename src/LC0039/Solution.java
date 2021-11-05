package LC0039;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, path, 0, target, res);
        return res;
    }

    private void dfs(int[] candidates, LinkedList<Integer> path, int start, int target, ArrayList<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, path, i, target - candidates[i], res);
            path.removeLast();
        }
    }
}