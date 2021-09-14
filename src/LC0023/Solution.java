package LC0023;

import java.util.PriorityQueue;

/**
 * @author zhanglei211 on 2021/9/14.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            if (poll.next != null) {
                heap.add(poll.next);
            }
            dummy.next = poll;
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}