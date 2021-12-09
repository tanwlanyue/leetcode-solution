package LC0232;

import java.util.ArrayDeque;

/**
 * 232. 用栈实现队列 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 57.38% 的用户
 * 
 * @author zhanglei211 on 2021/10/27.
 */
class MyQueue {
    ArrayDeque<Integer> stack1;
    ArrayDeque<Integer> stack2;

    public MyQueue() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}