package LC0530;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(pre!=null){
            min=Math.min(min,Math.abs(root.val-pre.val));
        }
        pre=root;
        inOrder(root.right);
    }
}