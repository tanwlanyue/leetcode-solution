package LC0633;

/**
 * 双指针+二分 求平方根 Math.sqrt()
 * 注意大数
 * TODO 还可以优化
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (l <= r) {
            long sum = (long) l * l + (long) r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}