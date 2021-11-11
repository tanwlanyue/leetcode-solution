package LC0009;

import java.util.ArrayDeque;

/**
 * 回文数
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return x == y || x == y / 10;
    }
}