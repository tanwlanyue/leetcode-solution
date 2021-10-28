package LC0008;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public int myAtoi(String s) {
        String trim = s.trim();
        char[] arr = trim.toCharArray();
        boolean positive = true;
        long d = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] == '+') {
                    continue;
                } else if (arr[i] == '-') {
                    positive = false;
                    continue;
                }
            }
            int num = arr[i] - '0';
            if (num >= 0 && num <= 9) {
                d = d * 10 + num;
                if (positive && d > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (!positive && -d < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) (positive ? d : -d);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE % 10);
    }
}