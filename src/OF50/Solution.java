package OF50;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhanglei211 on 2021/11/19.
 */
class Solution {
    public char firstUniqChar(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - '0']++;
        }

        for (char c : s.toCharArray()) {
            if (frequency[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}