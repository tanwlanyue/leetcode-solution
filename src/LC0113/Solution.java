package LC0113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        lists = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path);
        return lists;
    }

    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root != null) {
            int sum = targetSum - root.val;
            path.add(root.val);
            if (root.left == null && root.right == null && sum == 0) {
                lists.add(new ArrayList<>(path));
            }
            dfs(root.left, sum, path);
            dfs(root.right, sum, path);
            path.removeLast();
        }
    }
}