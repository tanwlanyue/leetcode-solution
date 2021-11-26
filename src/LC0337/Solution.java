package LC0337;

/**
 * @author zhanglei211 on 2021/11/26.
 */
class Solution {
    public int rob(TreeNode root) {
        int[] count = robTree(root);
        return Math.max(count[0], count[1]);
    }

    public int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] count = new int[2];
        int[] leftCount = robTree(root.left);
        int[] rightCount = robTree(root.right);
        count[0] = root.val + leftCount[1] + rightCount[1];
        count[1] = Math.max(leftCount[0], leftCount[1]) + Math.max(rightCount[0], rightCount[1]);
        return count;
    }
}