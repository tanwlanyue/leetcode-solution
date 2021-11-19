package LC0232;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/10/27.
 */
class MyQueue {
    ArrayDeque<Integer> leftStack;
    ArrayDeque<Integer> rightStack;

    public MyQueue() {
        this.leftStack = new ArrayDeque<>();
        this.rightStack = new ArrayDeque<>();
    }

    public void push(int x) {
        leftStack.push(x);
    }

    public int pop() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.pop();
    }

    public int peek() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.peek();
    }

    public boolean empty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }
}
