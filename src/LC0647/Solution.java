package LC0647;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}