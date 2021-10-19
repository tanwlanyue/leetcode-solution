package LC0227;

import java.util.ArrayDeque;

/**
 * 计算器
 * @author zhanglei211 on 2021/10/19.
 */
class Solution {
    public int calculate(String s) {
        char[] arr = s.trim().toCharArray();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        int d = 0;
        char op = '+';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' '){
                continue;
            }
            if (Character.isDigit(arr[i])) {
                d = d * 10 + (arr[i] - '0');
            }
            if (!Character.isDigit(arr[i]) || i == arr.length - 1) {
                if (op == '+') {
                    numStack.push(d);
                } else if (op == '-') {
                    numStack.push(-d);
                } else {
                    numStack.push(op == '*' ? numStack.pop() * d : numStack.pop() / d);
                }
                op = arr[i];
                d = 0;
            }
        }
        int ret = 0;
        while (!numStack.isEmpty()) {
            ret += numStack.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 3/2 "));
    }
}