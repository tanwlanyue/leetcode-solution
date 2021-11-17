package LC0096;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {

    public int numTrees(int n) {
        int[] table = new int[n + 1];
        return count(n,table);
    }

    private int count(int n, int[] table) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        if (table[n] != 0) {
            return table[n];
        }
        int total = 0;
        for (int i = 0; i <= n - 1; i++) {
            total += count(i,table) * count(n - i - 1,table);
        }
        table[n] = total;
        return table[n];
    }

    public static void main(String[] args) {
        new Solution().numTrees(3);
    }
}