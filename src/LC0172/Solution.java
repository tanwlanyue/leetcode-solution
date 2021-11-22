package LC0172;

/**
 * 阶乘后的零
 * 求5     要注意25=5*5 能拆成
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n / 5 != 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}