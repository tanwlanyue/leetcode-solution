package LC0206;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {

    /**
     * 想象 a → b ← c ← d，a是head，理解 head.next.next = head;
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // public ListNode reverseList(ListNode head) {
    // ListNode newHead = null;
    // while (head != null) {
    // ListNode next = head.next;
    // head.next = newHead;
    // newHead = head;
    // head = next;
    // }
    // return newHead;
    // }
}