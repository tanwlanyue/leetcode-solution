package LC0129;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        int p = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += p;
        }
        dfs(root.left, p);
        dfs(root.right, p);
    }
}