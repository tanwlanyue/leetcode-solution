package LC0076;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int minLen = s.length() + 1;
        int i = 0, j = 0;
        int length = s.length();
        HashMap<Character, Integer> needMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int invalid = needMap.size();
        while (j < length) {
            char c = s.charAt(j);
            if (needMap.containsKey(c)) {
                Integer num = needMap.get(c);
                if (num == 1) {
                    invalid--;
                }
                needMap.put(c, num - 1);
            }
            j++;
            while (invalid == 0) {
                int len = j - i;
                if (len < minLen) {
                    minLen = len;
                    start = i;
                }
                char d = s.charAt(i);
                if (needMap.containsKey(d)) {
                    Integer num = needMap.get(d);
                    if (num == 0) {
                        invalid++;
                    }
                    needMap.put(d, num + 1);
                }
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}