package LC0958;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean appearNull = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                appearNull = true;
            } else {
                if (appearNull) {
                    return false;
                }
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return true;
    }
}