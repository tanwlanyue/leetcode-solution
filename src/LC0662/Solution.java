package LC0662;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/11/10.
 */
class Solution {

    HashMap<Integer, Integer> depthLeftIndexMap = new HashMap<>();
    int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int i) {
        if (root == null) {
            return;
        }
        depthLeftIndexMap.putIfAbsent(depth, i);
        maxWidth = Math.max(maxWidth, i - depthLeftIndexMap.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * i + 1);
        dfs(root.right, depth + 1, 2 * i + 2);
    }
}