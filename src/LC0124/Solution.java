package LC0124;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = root.val;
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int sum = left + right + root.val;
        maxPath = Math.max(sum, maxPath);
        return Math.max(left, right) + root.val;
    }
}