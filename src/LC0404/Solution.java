package LC0404;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left, 0);
        dfs(root.right, 1);
        return sum;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && i == 0) {
            sum += root.val;
        }
        dfs(root.left, 0);
        dfs(root.right, 1);
    }
}