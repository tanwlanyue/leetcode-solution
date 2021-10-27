package LC0061;

/**
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = head;
        int len = 0;
        ListNode tail = head;
        while (dummy != null) {
            len++;
            tail = dummy;
            dummy = dummy.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        k = len - k;
        dummy = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            pre = dummy;
            dummy = dummy.next;
        }
        ListNode newHead = pre.next;
        pre.next = null;
        tail.next = head;
        return newHead;
    }
}