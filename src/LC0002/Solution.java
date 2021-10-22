package LC0002;

/**
 * @author zhanglei211 on 2021/10/21.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        int plus = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + plus;
            plus = sum >= 10 ? 1 : 0;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        dummy.next = plus == 1 ? new ListNode(1) : null;
        return dummyHead.next;
    }
}