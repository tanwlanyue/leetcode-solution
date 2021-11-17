package LC0443;

/**
 * @author zhanglei211 on 2021/9/15.
 */
class Solution {
    public int compress(char[] chars) {
        int rPos = 1, wPos = 1;
        int length = chars.length;
        char pre = chars[0];
        int count = 1;
        while (rPos < length) {
            char cur = chars[rPos];
            if (cur != pre) {
                if (count != 1) {
                    int left = wPos;
                    while (count != 0) {
                        int y = count % 10;
                        chars[wPos++] = (char) ('0' + y);
                        count = count / 10;
                    }
                    swap(chars, left, wPos - 1);
                }
                pre = cur;
                chars[wPos++] = pre;
                count = 1;
            } else {
                count++;
            }
            rPos++;
        }
        if (count != 1) {
            int left = wPos;
            while (count != 0) {
                int y = count % 10;
                chars[wPos++] = (char) ('0' + y);
                count = count / 10;
            }
            swap(chars, left, wPos - 1);
        }
        return wPos;
    }

    private void swap(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

    }
}