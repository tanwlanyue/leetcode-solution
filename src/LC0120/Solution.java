package LC0120;

import java.util.List;

/**
 * 120. 三角形最小路径和 </br>
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 95.80% 的用户 </br>
 * 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 42.41% 的用户
 * 
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[level];
        for (List<Integer> list : triangle) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                if (i == 0) {
                    dp[i] = dp[i] + list.get(i);
                } else if (i == size - 1) {
                    dp[i] = dp[i - 1] + list.get(i);
                } else {
                    dp[i] = Math.min(dp[i - 1], dp[i]) + list.get(i);
                }
            }
        }
        int min = dp[0];
        for (int j : dp) {
            min = Math.min(min, j);
        }
        return min;
    }
}