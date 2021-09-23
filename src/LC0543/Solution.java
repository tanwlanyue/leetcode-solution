package LC0543;

import java.util.HashMap;

/**
 * 注意孩子为null时长度的计算，若为null直接为0
 * @author zhanglei211 on 2021/9/24.
 */
class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int height = getHeight(root);
        max = Math.max(max, height);
        return max;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = root.left == null ? 0 : getHeight(root.left) + 1;
        int rightLen = root.right == null ? 0 : getHeight(root.right) + 1;
        max = Math.max(max, leftLen+rightLen);
        return Math.max(leftLen, rightLen);
    }
}