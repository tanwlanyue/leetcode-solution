package LC0567;

/**
 * 字符串的排列
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']--;
        }
        int left = 0, right = 0;
        while (right < len2) {
            arr[s2.charAt(right) - 'a']++;
            while (arr[s2.charAt(right) - 'a'] > 0) {
                arr[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) {
                return true;
            }
            right++;
        }
        return false;
    }
}