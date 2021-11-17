package OF10_1;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}