package LC0152;

/**
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int maxProduct = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            maxProduct = Math.max(maxProduct, dp[i][0]);
        }
        return maxProduct;
    }
}