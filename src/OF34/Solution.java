package OF34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, target, path);
        return lists;
    }

    private void dfs(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        target = target - root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && target == 0) {
            lists.add(new ArrayList<>(path));
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.removeLast();
    }
}