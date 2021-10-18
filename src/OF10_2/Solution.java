package OF10_2;

/**
 * @author zhanglei211 on 2021/10/18.
 */
class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            int sum = dp[i - 2] + dp[i - 1];
            dp[i] = sum % 1000000007;
        }
        return dp[n - 1];
    }
}