package LC0090;

import java.util.*;

/**
 * 子集 II 有重复元素，不能包含重复的子集
 * @author zhanglei211 on 2021/10/22.
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> path, ArrayList<List<Integer>> res) {
        ArrayList<Integer> list = new ArrayList<>(path);
        res.add(list);
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                dfs(nums, i + 1, path, res);
                path.removeLast();
            }
        }
    }
}