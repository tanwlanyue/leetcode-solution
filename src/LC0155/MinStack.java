package LC0155;

import java.util.ArrayList;

/**
 * minStack存的下标
 * @author zhanglei211 on 2021/10/19.
 */
class MinStack {

    ArrayList<Integer> numStack;
    ArrayList<Integer> minStack;

    public MinStack() {
        this.numStack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }

    public void push(int val) {
        numStack.add(val);
        if (minStack.isEmpty()) {
            minStack.add(0);
        } else {
            if (numStack.get(minStack.get(minStack.size() - 1)) > val) {
                minStack.add(numStack.size() - 1);
            }
        }
    }

    public void pop() {
        numStack.remove(numStack.size() - 1);
        if (numStack.size() == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        return numStack.get(numStack.size() - 1);
    }

    public int getMin() {
        return numStack.get(minStack.get(minStack.size() - 1));
    }
}
