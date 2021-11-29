package CI08_11;

/**
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    public int waysToChange(int n) {
        int[] coins = { 25, 10, 5, 1 };
        int[] dp = new int[n + 1];
        for (int coin : coins) {
            for (int i = 0; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                    dp[i] = dp[i] % 1000000007;
                }
            }
        }
        return dp[n];
    }
}