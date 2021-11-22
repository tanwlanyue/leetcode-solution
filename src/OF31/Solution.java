package OF31;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}