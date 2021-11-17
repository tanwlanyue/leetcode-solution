package LC0114;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        flatten(leftChild);
        flatten(rightChild);
        root.left=null;
        if (leftChild == null) {
            root.right = rightChild;
        } else {
            root.right = leftChild;
            if (rightChild != null) {
                while (leftChild.right != null) {
                    leftChild = leftChild.right;
                }
                leftChild.right = rightChild;
            }
        }
    }
}