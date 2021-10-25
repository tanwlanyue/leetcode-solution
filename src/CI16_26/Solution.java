package CI16_26;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/10/25.
 */
class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char op = '+';
        int d = 0;
        s=s.trim();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' '){
                continue;
            }
            if (Character.isDigit(arr[i])) {
                d = d * 10 + arr[i] - '0';
            }
            if (!Character.isDigit(arr[i]) || i == arr.length - 1) {
                if (op == '*') {
                    stack.push(stack.pop() * d);
                } else if (op == '/') {
                    stack.push(stack.pop() / d);
                } else if (op == '+') {
                    stack.push(d);
                } else if (op == '-') {
                    stack.push(-d);
                }
                d = 0;
                op = arr[i];
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;

    }

    public static void main(String[] args) {
        new Solution().calculate(" 3/2 ");
    }
}