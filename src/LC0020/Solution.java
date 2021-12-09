package LC0020;

import java.util.ArrayDeque;

/**
 * 20. 有效的括号 </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.92% 的用户 </br>
 * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 92.64% 的用户
 * 
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}