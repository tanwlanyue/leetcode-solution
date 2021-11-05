package LC0024;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        while (head != null) {
            if (head.next == null) {
                dummy.next = head;
                head = head.next;
                dummy = dummy.next;
            } else {
                ListNode next = head.next.next;
                dummy.next = head.next;
                head.next.next = head;
                head = next;
                dummy = dummy.next.next;
            }
        }
        // warning
        dummy.next = null;
        return dummyHead.next;
    }
}