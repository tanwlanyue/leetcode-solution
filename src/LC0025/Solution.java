package LC0025;

/**
 * @author zhanglei211 on 2021/9/13.
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = dummy;
        ListNode tail = dummy;
        ListNode start = dummy.next;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 不足k个节点时，break
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            reverse(start);
            tail.next = end;
            start.next = next;

            tail = start;
            end = start;
            start = next;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}