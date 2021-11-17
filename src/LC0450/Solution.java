package LC0450;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    TreeNode root;
    TreeNode pre;
    public TreeNode deleteNode(TreeNode root, int key) {
        this.root = root;
        inOrder(root, key, null);
        return this.root;
    }

    void inOrder(TreeNode root, int key, TreeNode parent) {
        if (root == null) {
            return;
        }
        inOrder(root.left, key, root);
        if (root.val == key) {
            if (parent == null) {
                if (root.left == null) {
                    this.root = root.right;
                } else if (root.right == null) {
                    this.root = root.left;
                } else {
                    TreeNode newRoot=root.left;
                    TreeNode subRightNode=root.right;
                    this.root=newRoot;
                    pre.right=subRightNode;
                }
            }
            // 被删除的节点是左孩子
            else if (parent.left == root) {
                if (root.left == null) {
                    parent.left = root.right;
                } else if (root.right == null) {
                    parent.left = root.left;
                } else {
                    TreeNode newRoot=root.left;
                    parent.left=newRoot;
                    TreeNode subRightNode=root.right;
                    pre.right=subRightNode;
                }
            }
            // 被删除的节点是右孩子
            else if (parent.right == root) {
                if (root.left == null) {
                    parent.right = root.right;
                } else if (root.right == null) {
                    parent.right = root.left;
                } else {
                    TreeNode newRoot=root.left;
                    parent.right=newRoot;
                    TreeNode subRightNode=root.right;
                    pre.right=subRightNode;
                }
            }
            return;
        }
        pre = root;
        inOrder(root.right, key, root);
    }
}