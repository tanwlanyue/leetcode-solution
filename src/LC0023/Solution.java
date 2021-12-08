package LC0023;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表 </br>
 * 执行用时： 6 ms , 在所有 Java 提交中击败了 35.55% 的用户 </br>
 * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 33.40% 的用户
 * 
 * @author zhanglei211 on 2021/9/14.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
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