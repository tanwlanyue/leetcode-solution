package LC0494;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) / 2;
        if (target < 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[target];
    }
}