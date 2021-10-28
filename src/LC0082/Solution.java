package LC0082;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode dummyHead = dummy;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int currVal = head.val;
                while (head != null && head.val == currVal) {
                    head = head.next;
                }
            } else {
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            }
        }
        dummy.next = head;
        return dummyHead.next;
    }
}
