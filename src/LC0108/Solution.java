package LC0108;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toTree(nums, 0, nums.length - 1);
    }

    private TreeNode toTree(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toTree(nums, i, mid - 1);
        root.right = toTree(nums, mid + 1, j);
        return root;
    }
}