package LC0295;

import java.util.PriorityQueue;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class MedianFinder {

    PriorityQueue<Integer> sHeap;
    PriorityQueue<Integer> bHeap;

    public MedianFinder() {
        // 比中位数小
        sHeap = new PriorityQueue<>((a, b) -> b - a);
        // 比中位数大
        bHeap = new PriorityQueue<>((a, b) -> a - b);

    }

    public void addNum(int num) {
        if (sHeap.size() == bHeap.size()) {
            if (sHeap.isEmpty()) {
                sHeap.add(num);
            } else {
                if (num > bHeap.peek()) {
                    bHeap.add(num);
                    sHeap.add(bHeap.poll());
                } else {
                    sHeap.add(num);
                }
            }
        } else {
            if (num < sHeap.peek()) {
                sHeap.add(num);
                bHeap.add(sHeap.poll());
            } else {
                bHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (sHeap.size() == bHeap.size()) {
            return sHeap.size() == 0 ? 0 : (sHeap.peek() + bHeap.peek()) / 2.0;
        } else {
            return sHeap.peek();
        }
    }
}