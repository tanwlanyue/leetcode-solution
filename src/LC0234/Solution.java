package LC0234;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null&&fast.next!=null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            pre = slow;
            slow = slow.next;
        }
        ListNode head2 = reverse(pre.next);
        pre.next = null;
        while (head != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead=head;
        while (head!=null){
            ListNode next = head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}