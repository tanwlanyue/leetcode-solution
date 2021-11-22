package LC0701;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node=root;
        while (true) {
            if (node.val > val) {
                if(node.left==null){
                    node.left=new TreeNode(val);
                    break;
                }
                node = node.left;
            } else if (node.val < val) {
                if(node.right==null){
                    node.right=new TreeNode(val);
                    break;
                }
                node = node.right;
            }
        }
        return root;
    }
}
