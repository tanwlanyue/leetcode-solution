package LC0005;

/**
 * 5. 最长回文子串 </br>
 * 执行用时： 22 ms , 在所有 Java 提交中击败了 87.02% 的用户 </br>
 * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 48.75% 的用户
 * 
 * @author zhanglei211 on 2021/10/21.
 */
class Solution {
    String maxStr = "";
    int maxLen = 0;

    public String longestPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            range(s, i, i);
            range(s, i, i + 1);
        }
        return maxStr;
    }

    private void range(String s, int i, int j) {
        int length = s.length();
        if (i < 0 || i >= length || j < 0 || j >= length) {
            return;
        }
        while (i >= 0 && j < length) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        int begin = i + 1;
        int len = j - i - 1;
        if (len > maxLen) {
            maxLen = len;
            maxStr = s.substring(begin, begin + len);
        }
    }
}