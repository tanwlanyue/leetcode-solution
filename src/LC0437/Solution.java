package LC0437;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        return count;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        check(root, targetSum);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    private void check(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum - root.val == 0) {
            count++;
        }
        check(root.left, sum - root.val);
        check(root.right, sum - root.val);
    }
}
