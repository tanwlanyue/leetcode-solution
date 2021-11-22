package OF07;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        this.map = map;
        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        Integer splitIndex = map.get(rootVal);
        int leftCount = splitIndex - il;
        root.left = buildTree(preorder, inorder, pl + 1, pl + leftCount, il, splitIndex - 1);
        root.right = buildTree(preorder, inorder, pl + leftCount + 1, pr, splitIndex + 1, ir);
        return root;
    }
}