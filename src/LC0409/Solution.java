package LC0409;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public int longestPalindrome(String s) {
        int length = s.length();
        int[] cnt = new int[128];
        int maxJi = 1;
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int len = 0;
        int containJi = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] % 2 == 0) {
                len += cnt[i];
            } else {
                containJi = 1;
                len += cnt[i] - 1;
            }
        }
        return len + containJi;
    }
}