package LC0559;

/**
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }
        return max + 1;
    }
}