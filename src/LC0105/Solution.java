package LC0105;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int length = preorder.length;
        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pi, int pj, int ii, int ij) {
        if (pi > pj) {
            return null;
        }
        int rootVal = preorder[pi];
        TreeNode root = new TreeNode(rootVal);
        Integer splitIndex = map.get(rootVal);
        int leftTreeNum = (splitIndex - 1) - ii + 1;
        root.left = buildTree(preorder, inorder, pi + 1, pi + leftTreeNum, ii, splitIndex - 1);
        root.right = buildTree(preorder, inorder, pi + leftTreeNum + 1, pj, splitIndex + 1, ij);
        return root;
    }
}