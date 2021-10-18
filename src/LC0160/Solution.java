package LC0160;

/**
 * @author zhanglei211 on 2021/10/18.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (true) {
            if (ha == hb) {
                return ha;
            }
            ha = (ha == null) ? headB : ha.next;
            hb = (hb == null) ? headA : hb.next;
        }
    }
}