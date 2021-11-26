package LC0028;

/**
 * 
 * TODO KMP
 * 
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {

    private int[] generateNextArray(String needle) {
        int length = needle.length();
        char[] charArray = needle.toCharArray();
        int[] next = new int[length];
        next[0] = 0;
        for (int i = 1, j = 0; i < length; i++) {
            while (j > 0 && charArray[i] != charArray[j]) {
                j = next[j - 1];
            }
            if (charArray[i] == charArray[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if (needleLength == 0) {
            return 0;
        }

        char[] charArray = needle.toCharArray();
        int[] next = generateNextArray(needle);
        int originLength = haystack.length();
        char[] s = haystack.toCharArray();
        for (int i = 0, j = 0; i < originLength; i++) {
            while (j > 0 && s[i] != charArray[j]) {
                j = next[j - 1];
            }
            if (s[i] == charArray[j]) {
                j++;
            }
            if (j == needleLength) {
                return i - needleLength + 1;
            }
        }
        return -1;
    }
}