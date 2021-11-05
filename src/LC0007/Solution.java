package LC0007;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean positive = true;
        if (x < 0) {
            x = -x;
            positive = false;
        }
        long a = 0;
        while (x != 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        a = positive ? a : -a;
        if (a > Integer.MAX_VALUE) {
            return 0;
        }
        if (a < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) a;
    }
}