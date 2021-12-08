package LC0113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 58.47% 的用户
 * 
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path, lists);
        return lists;
    }

    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> path, ArrayList<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        targetSum = targetSum - root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            lists.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum, path, lists);
        dfs(root.right, targetSum, path, lists);
        path.removeLast();
    }
}