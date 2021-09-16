package LC0083;

/**
 * @author zhanglei211 on 2021/9/16.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int val = head.val;
        ListNode next = head.next;
        while (next!=null){
            if(next.val==val){
                next=next.next;
            }else {
                break;
            }
        }
        head.next=deleteDuplicates(next);
        return head;
    }
}
