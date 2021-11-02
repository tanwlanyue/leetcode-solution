package OF43;

/**
 * 大数乘法
 * @author zhanglei211 on 2021/11/2.
 */
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + m * n;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            builder.append(res[i]);
        }
        return builder.toString();
    }
}