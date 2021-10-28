package LC0143;

/**
 * 重排链表
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummy = head;
        int count = 0;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        int step = (count - 1) / 2;
        ListNode pre = head;
        for (int i = 0; i < step; i++) {
            pre = pre.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        ListNode other = reverse(next);
        while (other != null) {
            ListNode headNext = head.next;
            head.next = other;
            other = other.next;
            head.next.next = headNext;
            head = headNext;
        }
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