package OF24;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}