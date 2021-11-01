package LC0098;

/**
 * @author zhanglei211 on 2021/11/1.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return valid(root.left, minValue, root.val) && valid(root.right, root.val, maxValue);
    }
}
