package LC0424;

/**
 * TODO
 * 
 * @author zhanglei211 on 2021/12/1.
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        int length = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        int maxCount = 0;
        char maxCharacter = s.charAt(0);
        while (j < length) {
            if (++count[arr[j] - 'A'] > maxCount) {
                maxCount = count[arr[j] - 'A'];
                maxCharacter = arr[j];
            }
            j++;
            while (j - i > maxCount + k) {
                --count[arr[i] - 'A'];
                if (maxCharacter == arr[i]) {
                    maxCount--;
                    for (int m = 0; m < count.length; m++) {
                        if (count[m] > maxCount) {
                            maxCount = count[m];
                            maxCharacter = (char) (m + 'A');
                        }
                    }
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}