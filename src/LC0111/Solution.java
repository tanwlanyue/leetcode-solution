package LC0111;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {

    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    break;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return depth;
    }
}