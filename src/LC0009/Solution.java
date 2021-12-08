package LC0009;

/**
 * 9. 回文数 </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 65.74% 的用户
 * 
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return x == y || y / 10 == x;
    }
}