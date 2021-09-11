package LC0003;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charPosMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (charPosMap.containsKey(c)) {
                left = Math.max(charPosMap.get(c) + 1, left);
            }
            maxLen = Math.max(maxLen, i - left + 1);
            charPosMap.put(c, i);
        }
        return maxLen;
    }
}