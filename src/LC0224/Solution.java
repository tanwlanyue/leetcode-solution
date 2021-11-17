package LC0224;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        int d = 0;
        char op = '+';
        int i = 0;
        int length = s.length();
        int sum = 0;
        while (i < length) {
            char c = arr[i];
            if (Character.isDigit(c) || c == '+' || c == '-' || c == '(' || c == ')') {
                if (Character.isDigit(c)) {
                    d = d * 10 + c - '0';
                } else if (c == '+' || c == '-') {
                    d = op == '-' ? -d : d;
                    sum += d;
                    d = 0;
                    op = c;
                } else if (c == '(') {
                    int j = i + 1;
                    int leftCount = 1;
                    while (j < length) {
                        if (arr[j] == '(') {
                            leftCount++;
                        } else if (arr[j] == ')') {
                            if (--leftCount == 0) {
                                break;
                            }
                        }
                        j++;
                    }
                    d = calculate(s.substring(i + 1, j));
                    i = j - 1;
                }
            }
            i++;
        }
        sum += op == '-' ? -d : d;
        return sum;
    }

}