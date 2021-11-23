package LC0279;

/**
 * 4平方定理
 * 
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= n; j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}