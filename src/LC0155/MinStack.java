package LC0155;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/10/19.
 */
class MinStack {

    class Node {
        int num;
        int val;

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }

    ArrayDeque<Integer> numStack;
    ArrayDeque<Node> minStack;

    public MinStack() {
        this.numStack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        numStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(new Node(1, val));
        } else {
            if (val < minStack.peek().val) {
                minStack.push(new Node(1, val));
            } else {
                Node node = minStack.peek();
                node.num = node.num + 1;
            }

        }
    }

    public void pop() {
        numStack.pop();
        Node node = minStack.peek();
        if (node.num == 1) {
            minStack.pop();
        } else {
            node.num = node.num - 1;
        }

    }

    public int top() {
        return numStack.peek();
    }

    public int getMin() {
        return minStack.peek().val;
    }
}
