package LC0069;

/**
 * @author zhanglei211 on 2021/9/15.
 */
class Solution {
    public int mySqrt(int x) {
        int i = 0, j = x;
        int res = 0;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            long c = (long) mid * mid;
            if (c > x) {
                j = mid - 1;
            } else {
                res = mid;
                i = mid + 1;
            }
        }
        return res;
    }

    public double extendSqrt(int x) {
        double i = 0, j = x;
        double res = 0;
        double cha = 0.00001;
        while (Math.abs(x - res*res) > cha) {
            double mid = (j - i) / 2 + i;
            double c = mid * mid;
            if (c > x) {
                j = mid;
            } else {
                res = mid;
                i = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        double v = new Solution().extendSqrt(8);
        System.out.println(String.format("%.3f",v));
    }
}