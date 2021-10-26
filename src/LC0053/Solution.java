package LC0053;

/**
 * @author zhanglei211 on 2021/10/26.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // 以nums[i]结尾的最大连续子数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}