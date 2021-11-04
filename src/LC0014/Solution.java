package LC0014;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (String str : strs) {
            int length = str.length();
            minLen = Math.min(minLen, length);
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}