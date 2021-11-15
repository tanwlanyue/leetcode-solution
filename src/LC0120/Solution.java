package LC0120;

import java.util.List;

/**
 * 三角形最小路径和
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = dp[i - 1] + list.get(i);
            for (int j = i - 1; j > 0; j--) {
                // 从后往前扫
                dp[i] = Math.min(dp[i - 1], dp[i]) + list.get(i);
            }
            dp[0] = dp[0] + list.get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < dp.length; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}