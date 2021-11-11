package LC0402;

import java.util.ArrayDeque;

/**
 *  移掉K位数字
 * @author zhanglei211 on 2021/11/10.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (k >= length) {
            return "0";
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char[] chars = num.toCharArray();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = chars[i] - '0';
        }
        // 单调栈
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }
        // 去掉多余
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        String s = builder.reverse().toString();
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        s = s.substring(i);
        return s.length() == 0 ? "0" : s;
    }
}
