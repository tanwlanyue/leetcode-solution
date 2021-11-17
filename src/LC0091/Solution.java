package LC0091;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        char[] arr = s.toCharArray();
        // arr[i]结尾的编码数
        int[] dp = new int[length];
        dp[0] = (arr[0] - '0' >= 1 && arr[0] - '9' <= 9) ? 1 : 0;
        for (int i = 1; i < length; i++) {
            int num = arr[i] - '0';
            if (num >= 1 && num <= 9) {
                dp[i] += dp[i - 1];
            }
            int preNum = arr[i - 1] - '0';
            if ((preNum == 1 && num >= 0 && num <= 9) || (preNum == 2 && num >= 0 && num <= 6)) {
                dp[i] = dp[i] + i - 2 >= 0 ? dp[i - 2] : 1;
            }
        }
        return dp[length - 1];
    }
}
