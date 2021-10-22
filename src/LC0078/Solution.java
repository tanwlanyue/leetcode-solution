package LC0078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/22.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int i, LinkedList<Integer> path, ArrayList<List<Integer>> res) {
        if (i >= nums.length) {
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
            return;
        }
        path.add(nums[i]);
        dfs(nums, i + 1, path, res);
        path.removeLast();
        dfs(nums, i + 1, path, res);
    }
}
