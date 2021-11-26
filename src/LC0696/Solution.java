package LC0696;

/**
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        int i = 0;
        int checkNum = charArray[0] - '0';
        int count = 0;
        int preLen = 0;
        while (i < length) {
            int curLen = 0;
            while (i < length) {
                if (charArray[i] - '0' == checkNum) {
                    curLen++;
                    i++;
                } else {
                    break;
                }
            }
            count = count + (preLen == 0 ? 0 : Math.min(preLen, curLen));
            preLen = curLen;
            checkNum = 1 - checkNum;
        }
        return count;
    }

}