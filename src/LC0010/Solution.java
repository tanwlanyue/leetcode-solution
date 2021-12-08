package LC0010;

/**
 * 10. 正则表达式匹配 </br>
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 37.58% 的用户 </br>
 * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 42.61% 的用户
 * 
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        for (int i = 1; i < pLen; i = i + 2) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
}