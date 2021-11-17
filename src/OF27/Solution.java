package OF27;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        root.right = mirrorTree(leftChild);
        root.left = mirrorTree(rightChild);
        return root;
    }

}