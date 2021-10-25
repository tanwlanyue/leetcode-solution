package CI02_07;

/**
 * @author zhanglei211 on 2021/10/25.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = countLen(headA);
        int lenB = countLen(headB);
        if(lenA>lenB){
            for (int i = 0; i < lenA - lenB; i++) {
                headA=headA.next;
            }
            while (headA!=null &&headB!=null){
                if(headA==headB){
                    return headA;
                }
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB=headB.next;
            }
            while (headA!=null &&headB!=null){
                if(headA==headB){
                    return headA;
                }
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }
    }

    int countLen(ListNode node) {
        ListNode head = node;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}