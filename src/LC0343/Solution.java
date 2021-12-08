package LC0343;

/**
 * 343. 整数拆分 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 8.61% 的用户
 * 
 * @author zhanglei211 on 2021/12/1.
 */
class Solution {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n % 3 == 0) {
            return (int) (Math.pow(3, (int) (n / 3)));
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, (int) (n / 3) - 1)) * 4;
        } else {
            return (int) (Math.pow(3, (int) (n / 3))) * 2;
        }
    }
    // public int integerBreak(int n) {
    // int[] dp = new int[n + 1];
    // for (int i = 2; i <= n; i++) {
    // int max = 0;
    // for (int j = 1; j < i; j++) {
    // max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
    // }
    // dp[i] = max;
    // }
    // return dp[n];
    // }

}