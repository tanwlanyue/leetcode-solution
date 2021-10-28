package LC0199;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list, int i) {
        if (root == null) {
            return;
        }
        if (i == list.size()) {
            list.add(root.val);
        }
        dfs(root.right, list, i + 1);
        dfs(root.left, list, i + 1);
    }
}