package LC0309;

/**
 * @author zhanglei211 on 2021/10/14.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        // dp[0] 没买 dp[1]持有 dp[2] 冷却
        int[][] dp = new int[length][3];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                dp[0][2] = 0;
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                dp[i][2] = dp[i - 1][1] + prices[i];
            }
        }
        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }
}