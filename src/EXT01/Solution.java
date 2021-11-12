package EXT01;

/**
 * 链表排序 1->4->3->2->5 给定一个链表奇数部分递增，偶数部分递减，要求在O(n)时间复杂度内将链表变成递增
 * 
 * @author zhanglei211 on 2021/11/10.
 */
public class Solution {

    public ListNode sortListNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode newhead = null;
        while (head != null) {
            dummy.next = head;
            head = head.next;
            if (head != null) {
                ListNode next = head.next;
                head.next = newhead;
                newhead = head;
                head = head.next;
            }
            dummy = dummy.next;
        }
        dummy.next = newhead;
        return dummyHead.next;
    }
}
