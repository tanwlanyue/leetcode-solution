package LC0123;

/**
 * 注意第一天的初始化
 * @author zhanglei211 on 2021/9/18.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 第一次已买
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            // 第一次已卖
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            // 第二次已买
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            // 第二次已卖
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
        }
        return dp[n - 1][3];
    }
}
