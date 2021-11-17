package OF42;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}