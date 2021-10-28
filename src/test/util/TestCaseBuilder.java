package test.util;

/**
 * @author zhanglei211 on 2021/10/28.
 */
public class TestCaseBuilder {
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
