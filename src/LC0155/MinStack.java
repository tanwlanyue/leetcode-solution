package LC0155;

import java.util.Stack;

/**
 * 155. 最小栈 </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.60% 的用户 </br>
 * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 97.96% 的用户
 * 
 * @author zhanglei211 on 2021/10/19.
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(stack.size() - 1);
        } else {
            if (val < stack.get(minStack.peek())) {
                minStack.push(stack.size() - 1);
            }
        }
    }

    public void pop() {
        stack.pop();
        if (stack.size() == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.get(minStack.peek());
    }
}