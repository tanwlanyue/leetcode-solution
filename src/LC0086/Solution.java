package LC0086;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(-1);
        ListNode right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next=null;
        left.next=rightHead.next;
        return leftHead.next;
    }
}