package LC0306;

/**
 * TODO
 * @author zhanglei211 on 2021/11/19.
 */
class Solution {
    boolean flag = false;

    public boolean isAdditiveNumber(String num) {
        return false;
    }

    private boolean check(String num, int start, String sum) {
        int length = sum.length();
        for (int i = 0; i < length; i++) {
            if (sum.charAt(i) != num.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

    private String sum(String num, int i, int j, int m, int n) {
        StringBuilder builder = new StringBuilder();
        int plus = 0;
        while (j >= i || n >= m || plus != 0) {
            int a = j >= i ? num.charAt(j) - '0' : 0;
            int b = n >= m ? num.charAt(n) - '0' : 0;
            int sum = a + b + plus;
            builder.append(sum % 10);
            plus = sum >= 10 ? 1 : 0;
            j--;
            n--;
        }
        return builder.toString();
    }
}