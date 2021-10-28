package LC0072;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        char[] arr1 = word1.toCharArray();
        int len2 = word2.length();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.max(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}