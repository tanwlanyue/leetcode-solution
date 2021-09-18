package LC0516;

/**
 * 最长回文子序列
 * 
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int length = s.length();
        int[][] dp = new int[length][length];
        int max = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (arr[i] == arr[j]) {
                    if (j - i < 3) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}