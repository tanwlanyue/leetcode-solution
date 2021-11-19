package LC0895;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author zhanglei211 on 2021/11/19.
 */
class FreqStack {
    HashMap<Integer, Integer> frequency;
    HashMap<Integer, Stack<Integer>> group;
    int maxFrequency = 0;

    public FreqStack() {
        this.frequency = new HashMap<>();
        this.group = new HashMap<>();
    }

    /**
     * 将整数 x 推入栈中。
     * 
     * @param val
     */
    public void push(int val) {
        int newFrequency = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, newFrequency);
        if (newFrequency > maxFrequency) {
            maxFrequency = newFrequency;
        }
        if (!group.containsKey(newFrequency)) {
            group.put(newFrequency, new Stack<>());
        }
        group.get(newFrequency).push(val);
    }

    /**
     * 它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
     * 
     * @return
     */
    public int pop() {
        Stack<Integer> stack = group.get(maxFrequency);
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            maxFrequency--;
        }
        frequency.put(pop, frequency.get(pop) - 1);
        return pop;
    }
}
