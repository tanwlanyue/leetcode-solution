package LC0415;

/**
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int plus = 0;
        int i = len1 - 1, j = len2 - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int m = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = m + n + plus;
            plus = sum >= 10 ? 1 : 0;
            builder.insert(0, sum % 10);
        }
        if (plus != 0) {
            builder.insert(0, plus);
        }
        return builder.toString();
    }
}