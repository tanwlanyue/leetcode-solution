package LC0739;

import java.util.ArrayDeque;

/**
 * 739. 每日温度 </br>
 * 执行用时： 22 ms , 在所有 Java 提交中击败了 92.32% 的用户 </br>
 * 内存消耗： 52.4 MB , 在所有 Java 提交中击败了 28.07% 的用户
 * 
 * @author zhanglei211 on 2021/12/8.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] arr = new int[length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                arr[pop] = i - pop;
            }
            stack.push(i);
        }
        return arr;
    }
}