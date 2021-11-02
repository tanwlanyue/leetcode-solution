package LC0032;

/**
 * ()(())  注意再加上(preIndex - 1 >= 0 ? dp[preIndex - 1] : 0)
 * @author zhanglei211 on 2021/11/1.
 */
class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        char[] arr = s.toCharArray();
        int max = 0;
        // dp[i] i 结尾的最长括号
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            char c = arr[i];
            if (c == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }
                if (arr[i - 1] == ')') {
                    int preIndex = i - 1 - dp[i - 1];
                    if (preIndex >= 0 && arr[preIndex] == '(') {
                        dp[i] = dp[i - 1] + 2 + (preIndex - 1 >= 0 ? dp[preIndex - 1] : 0);
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}