package OF52;

/**
 * @author zhanglei211 on 2021/11/12.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int step = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < step; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < step; i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}