package LC0110;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {

    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalance;
    }

    private int getHeight(TreeNode root) {
        if (!isBalance || root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return Math.max(left, right) + 1;
    }
}