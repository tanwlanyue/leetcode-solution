package LC0112;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum);
        return flag;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (flag || root == null) {
            return;
        }
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                flag = true;
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}