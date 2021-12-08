package LC0007;

/**
 * 7. 整数反转 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 27.02% 的用户
 * 
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            positive = false;
            x = -x;
        }
        int a = Integer.MAX_VALUE / 10;
        int b = Integer.MAX_VALUE % 10;
        int y = 0;
        while (x > 0) {
            if (positive) {
                if (y > a || (y == a && x % 10 > b)) {
                    return 0;
                }
            } else {
                if (y > a || (y == a && x % 10 > b + 1)) {
                    return 0;
                }
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return positive ? y : -y;
    }
}