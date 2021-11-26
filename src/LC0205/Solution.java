package LC0205;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (sArr[c] != tArr[d]) {
                return false;
            }
            // +1 是因为没有初始化sArr tArr值默认是0
            sArr[c] = i+1;
            tArr[d] = i+1;
        }
        return true;
    }
    // public boolean isIsomorphic(String s, String t) {
    // int sLen = s.length();
    // int tLen = t.length();
    // if (sLen != tLen) {
    // return false;
    // }
    // HashMap<Character, Character> map = new HashMap<>();
    //
    // for (int i = 0; i < sLen; i++) {
    // char c = s.charAt(i);
    // char d = t.charAt(i);
    // if (map.containsKey(c)) {
    // if (map.get(c) != d) {
    // return false;
    // }
    // } else {
    // if (map.containsValue(d)) {
    // return false;
    // } else {
    // map.put(c, d);
    // }
    // }
    // }
    // return true;
    // }
}