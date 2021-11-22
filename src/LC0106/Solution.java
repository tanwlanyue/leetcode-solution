package LC0106;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    // 左 根 右
    // 左 右 根
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = postorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        this.map = map;
        return buildTree(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir) {
            return null;
        }
        int rootVal = postorder[pr];
        TreeNode root = new TreeNode(rootVal);
        Integer rootValIndex = map.get(rootVal);
        int leftCount = rootValIndex - il;
        root.left = buildTree(inorder, postorder, il, rootValIndex - 1, pl, pl + leftCount - 1);
        root.right = buildTree(inorder, postorder, rootValIndex + 1, ir, pl + leftCount, pr - 1);
        return root;
    }
}