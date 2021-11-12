package LC0459;

/**
 * KMP优化？？
 * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int len = 1; len <= length / 2; len++) {
            if (length % len == 0) {
                int time = length / len;
                String base = s.substring(0, len);
                boolean flag = true;
                for (int i = 1; i < time; i++) {
                    int start = i * len;
                    int end = start + len - 1;
                    if (!check(s, start, end, base)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String s, int start, int end, String base) {
        for (int i = 0; i < base.length(); i++) {
            if (s.charAt(start + i) != base.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}