package LC0395;

/**
 * TODO
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {

    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (j - i + 1 >= k) {

                }
            }
        }
        return 0;
    }
}