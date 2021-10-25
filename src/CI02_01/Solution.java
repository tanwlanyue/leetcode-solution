package CI02_01;

import java.util.HashSet;

/**
 * @author zhanglei211 on 2021/10/25.
 */
class Solution {
    HashSet<Integer> set = new HashSet<>();

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (set.add(head.val)) {
            head.next = removeDuplicateNodes(next);
            return head;
        } else {
            return removeDuplicateNodes(next);
        }
    }
}