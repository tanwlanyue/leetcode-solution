package LC0443;

/**
 * @author zhanglei211 on 2021/9/15.
 */
class Solution {
    public int compress(char[] chars) {
        int length = chars.length;
        int writePos = 0;
        int readPos = 0;
        while (readPos < length) {
            int i = readPos + 1;
            while (i < length && chars[i] == chars[readPos]) {
                i++;
            }
            int len = i - readPos;
            chars[writePos++] = chars[readPos];
            if (len > 1) {
                char[] lenChar = String.valueOf(len).toCharArray();
                for (char c : lenChar) {
                    chars[writePos++] = c;
                }
            }
            readPos = i;
        }
        return writePos;
    }
}