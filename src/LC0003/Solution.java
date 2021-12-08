package LC0003;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串 </br>
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 98.42% 的用户 </br>
 * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 73.00% 的用户
 * 
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];
        Arrays.fill(table, -1);
        int length = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < length) {
            char c = s.charAt(j);
            if (table[c] != -1) {
                i = Math.max(i, table[c] + 1);
            }
            table[c] = j;
            j++;
            maxLen = Math.max(j - i, maxLen);
        }
        return maxLen;
    }
}