package LC0746;

/**
 * 746. 使用最小花费爬楼梯 执行用时： 1 ms , 在所有 Java 提交中击败了 90.56% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 5.13% 的用户
 * 
 * @author zhanglei211 on 2021/12/1.
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 1) {
            return cost[0];
        }
        int[] dp = new int[length];
        for (int i = 0; i < cost.length; i++) {
            if (i == 0) {
                dp[0] = cost[0];
            } else if (i == 1) {
                dp[1] = cost[1];
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }
}