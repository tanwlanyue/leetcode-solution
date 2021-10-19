package LC0738;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/10/19.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int length = temperatures.length;
        int[] ret = new int[length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                ret[pop] = i - pop;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ret[stack.pop()] = 0;
        }
        return ret;
    }
}
