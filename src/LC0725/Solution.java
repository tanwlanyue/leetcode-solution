package LC0725;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = count(head);
        int average = size / k;
        ListNode[] res = new ListNode[k];
        int duoSize = size % k;
        int c = 0;
        for (int i = 0; i < duoSize; i++) {
            res[c++] = head;
            for (int j = 0; j < average; j++) {
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        for (int i = 0; i < k - duoSize; i++) {
            res[c++] = head;
            for (int j = 0; j < average - 1; j++) {
                head = head.next;
            }
            if (head == null) {
                break;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return res;
    }

    private int count(ListNode head) {
        ListNode dummy = head;
        int count = 0;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        return count;
    }
}
