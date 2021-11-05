package OF09;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class CQueue {
    ArrayDeque<Integer> left;
    ArrayDeque<Integer> right;

    public CQueue() {
        this.left = new ArrayDeque<>();
        this.right = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        left.push(value);
    }

    public int deleteHead() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        return right.isEmpty() ? -1 : right.pop();
    }
}