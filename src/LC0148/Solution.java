package LC0148;

/**
 * 注意切分链表的时机 防止死循环
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        ListNode ha = sortList(head);
        ListNode hb = sortList(next);
        return merge(ha, hb);
    }

    private ListNode merge(ListNode ha, ListNode hb) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (ha != null && hb != null) {
            if (ha.val < hb.val) {
                dummy.next = ha;
                ha = ha.next;
                dummy = dummy.next;
            } else {
                dummy.next = hb;
                hb = hb.next;
                dummy = dummy.next;
            }
        }
        dummy.next = ha == null ? hb : ha;
        return dummyHead.next;
    }

    static ListNode buildListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        for (int i : arr) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return dummyHead.next;
    }

}