package OF48;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < arr.length) {
            char c = arr[j];
            if (map[c] != -1) {
                i = Math.max(i, map[c] + 1);
            }
            map[c] = j;
            j++;
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}