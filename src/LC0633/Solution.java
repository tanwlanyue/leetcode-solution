package LC0633;

/**
 * 双指针+二分 求平方根 Math.sqrt() 注意大数 费马平方和定理告诉我们：一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k+3 的质因子的幂均为偶数。
 * 
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            long sum = (long) i * i + (long) j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}