package LC0014;

/**
 * 14. 最长公共前缀 </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 70.14% 的用户 </br>
 * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 46.30% 的用户
 * 
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}