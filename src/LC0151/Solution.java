package LC0151;

/**
 * 先局部颠倒 再全部颠倒
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        char[] arr = trim.toCharArray();
        int length = arr.length;
        while (i < length) {
            int start = i;
            while (i < length && arr[i] != ' ') {
                i++;
            }
            reverse(arr, start, i - 1);
            while (i < length && arr[i] == ' ') {
                i++;
            }
        }
        i = length - 1;
        while (i >= 0) {
            while (i >= 0 && arr[i] != ' ') {
                builder.append(arr[i]);
                i--;
            }
            if (i >= 0) {
                builder.append(' ');
            }
            while (i >= 0 && arr[i] == ' ') {
                i--;
            }
        }
        return builder.toString();
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}