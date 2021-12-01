package OF46;

/**
 * @author zhanglei211 on 2021/11/30.
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = dp[i - 1] + (checkValid(s, i) ? 1 : 0);
            } else {
                dp[i] = dp[i - 1] + (checkValid(s, i) ? dp[i - 2] : 0);
            }
        }
        return dp[length - 1];
    }

    public boolean checkValid(String s, int i) {
        if (s.charAt(i - 1) == '1') {
            return true;
        } else if (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '5') {
            return true;
        } else {
            return false;
        }
    }
}