package LC0214;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/19.
 */
class Solution {
    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int length = s.length();
        int right = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (check(s, 0, i)) {
                right = i;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = length - 1; i > right; i--) {
            builder.append(s.charAt(i));
        }
        builder.append(s);
        return builder.toString();
    }

    private boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}