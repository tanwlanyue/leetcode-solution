package LC0225;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 98.80% 的用户
 * 
 * @author zhanglei211 on 2021/11/10.
 */
class MyStack {
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int ret = queue1.poll();
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return ret;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int ret = queue1.poll();
        queue2.offer(ret);
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return ret;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
