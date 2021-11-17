package LC0445;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        int plus = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + plus;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            plus = sum / 10;
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if (plus != 0) {
            dummy.next = new ListNode(plus);
        }
        return reverse(dummyHead.next);
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