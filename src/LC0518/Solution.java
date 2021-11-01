package LC0518;

/**
 * 避免重复 coins循环放外层
 * @author zhanglei211 on 2021/11/1.
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[] { 1, 2, 5 }));
    }
}