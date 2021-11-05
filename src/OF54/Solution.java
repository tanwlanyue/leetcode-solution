package OF54;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    int k;
    int target;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return target;
    }

    private void inOrder(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        inOrder(root.right);
        if (--k == 0) {
            target = root.val;
            return;
        }
        inOrder(root.left);
    }
}