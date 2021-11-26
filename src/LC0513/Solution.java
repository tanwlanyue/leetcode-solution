package LC0513;

import java.util.ArrayList;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {

    ArrayList<Integer> list = new ArrayList<>();

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return list.get(list.size() - 1);
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}