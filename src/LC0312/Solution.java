package LC0312;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {

    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] values = new int[len];
        values[0] = 1;
        values[len - 1] = 1;
        for (int i = 1; i < len - 1; i++) {
            values[i] = nums[i - 1];
        }
        int[][] dp = new int[len][len];
        for (int step = 3; step <= len; step++) {
            for (int i = 0; i < len - step + 1; i++) {
                int j = i + step - 1;
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}