package LC0328;

/**
 * 奇偶链表
 * 
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
    // public ListNode oddEvenList(ListNode head) {
    // ListNode oddH=new ListNode(-1);
    // ListNode odd=oddH;
    // ListNode evenH=new ListNode(-1);
    // ListNode even=evenH;
    // while (head!=null){
    // ListNode next = head.next;
    // odd.next=head;
    // head.next=null;
    // odd=odd.next;
    // head=next;
    // if(head!=null){
    // next= head.next;
    // head.next=null;
    // even.next=head;
    // even=even.next;
    // head=next;
    // }
    // }
    // even.next=null;
    // odd.next=evenH.next;
    // return oddH.next;
    // }
}