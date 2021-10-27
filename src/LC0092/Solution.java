package LC0092;

/**
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode pre = dummy;
        for (int i = 0; i < left; i++) {
            pre = slow;
            slow = slow.next;
        }
        for (int i = 0; i < right; i++) {
            fast = fast.next;
        }
        ListNode next = fast.next;
        fast.next = null;
        pre.next = reverse(slow);
        slow.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
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