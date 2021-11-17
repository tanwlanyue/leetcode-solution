package LC0134;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int[] toWillCost = new int[n];
        toWillCost[0] = gas[0] - cost[n - 1];
        for (int i = 1; i < n; i++) {
            toWillCost[i] = gas[i] - cost[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int init = gas[i];
            for (int j = 1; j <= n; j++) {
                int toIndex = (i + j) % n;
                init -= cost[i];
                if (init < 0) {
                    break;
                }
                init += gas[toIndex];
            }
            if (init > 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 });
    }
}