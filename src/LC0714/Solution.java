package LC0714;

/**
 * @author zhanglei211 on 2021/10/14.
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        // dp[0] 没买 dp[1]持有
        int[][] dp = new int[length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
        }
        return dp[length - 1][0];
    }
}