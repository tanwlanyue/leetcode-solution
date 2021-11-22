package LC0863;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 二叉树中所有距离为 K 的结点
 * 
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        return list;
    }

    int depth(TreeNode root, TreeNode target) {
        if (root == null) {
            return 0;
        }
        if (target != root) {
            return Math.min(depth(root.left, target), depth(root.right, target)) + 1;
        } else {
            return 1;
        }
    }
}