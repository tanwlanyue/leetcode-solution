package LC0150;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (Objects.equals(token, "-")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (Objects.equals(token, "*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (Objects.equals(token, "/")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}