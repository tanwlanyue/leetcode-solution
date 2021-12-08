package LC0438;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return list;
        }
        int[] window = new int[26];
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        for (int i = 0; i < pLen; i++) {
            window[s.charAt(i) - 'a']++;
        }
        if (compare(need, window)) {
            list.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - pLen) - 'a']--;
            if (compare(window, need)) {
                list.add(i - pLen + 1);
            }
        }
        return list;
    }

    private boolean compare(int[] window, int[] need) {
        for (int i = 0; i < 26; i++) {
            if (window[i] != need[i]) {
                return false;
            }
        }
        return true;
    }
}