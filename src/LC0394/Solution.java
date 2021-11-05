package LC0394;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        int i = 0;
        int d = 0;
        while (i < length) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                d = d * 10 + (c - '0');
                i++;
            } else if (c == '[') {
                int left = 1;
                int j = i + 1;
                while (j < length && left != 0) {
                    if (arr[j] == '[') {
                        left++;
                    }
                    if (arr[j] == ']') {
                        left--;
                    }
                    j++;
                }
                String str = decodeString(s.substring(i + 1, j - 1));
                for (int k = 0; k < d; k++) {
                    builder.append(str);
                }
                i = j;
                d = 0;
            } else {
                builder.append(c);
                i++;
            }
        }
        return builder.toString();
    }
}