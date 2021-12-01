/**
 * @author zhanglei211 on 2021/12/1.
 */
public class TreeNode {
    int val;
    LC0109.TreeNode left;
    LC0109.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, LC0109.TreeNode left, LC0109.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}