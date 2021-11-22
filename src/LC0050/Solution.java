package LC0050;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public double myPow(double x, int n) {
        long b = n;
        if (x == 0) {
            return 0.0d;
        }
        if (b == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            b = b / 2;
        }
        return res;
    }
}