package LC0257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    ArrayList<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path);
        return list;
    }

    private void dfs(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    builder.append(path.get(i));
                } else {
                    builder.append(path.get(i));
                    builder.append("->");
                }
            }
            list.add(builder.toString());
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }
}