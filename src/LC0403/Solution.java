package LC0403;

/**
 * @author zhanglei211 on 2021/9/22.
 */
class Solution {
    // public boolean canCross(int[] stones) {
    // if (stones[1] != 1) {
    // return false;
    // }
    // int n = stones.length;
    // HashSet<Integer>[] array = new HashSet[n];
    // for (int i = 0; i < array.length; i++) {
    // array[i] = new HashSet<>();
    // }
    // array[1].add(1);
    // for (int i = 2; i < stones.length; i++) {
    // for (int j = 1; j < i; j++) {
    // if (array[j].size() > 0) {
    // int step = stones[i] - stones[j];
    // if (array[j].contains(step) || array[j].contains(step - 1) || array[j].contains(step + 1)) {
    // array[i].add(step);
    // }
    // }
    // }
    // }
    // return array[n - 1].size() > 0;
    // }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int step = stones[i] - stones[j];
                // important
                if (step > j + 1) {
                    break;
                }
                if (dp[j][step] || dp[j][step - 1] || dp[j][step + 1]) {
                    dp[i][step] = true;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
