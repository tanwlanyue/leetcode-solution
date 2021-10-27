package LC0142;

/**
 * @author zhanglei211 on 2021/10/27.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (true) {
                    if (fast == slow) {
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }
}