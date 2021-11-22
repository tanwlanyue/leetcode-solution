package LC0230;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        int count = 0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (++count == k) {
                res = root.val;
                break;
            }
            root = root.right;
        }
        return res;
    }
}