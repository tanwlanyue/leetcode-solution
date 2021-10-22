package LC0005;

/**
 * @author zhanglei211 on 2021/10/21.
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        int index = 0;
        int maxLen = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = j - i < 3 || dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            index = i;
                        }
                    }
                }
            }
        }
        return s.substring(index, index + maxLen);
    }
}