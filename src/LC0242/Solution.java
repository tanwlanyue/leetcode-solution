package LC0242;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] need = new int[26];
        for (char c : t.toCharArray()) {
            need[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            need[c - 'a']--;
        }
        for (int i : need) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}