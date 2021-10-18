package LC0070;

/**
 * @author zhanglei211 on 2021/10/18.
 */
class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
}