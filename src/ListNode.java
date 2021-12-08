/**
 * @author zhanglei211 on 2021/12/1.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val).append(" -> ");
            head = head.next;
        }
        s.append("NULL");
        return s.toString();
    }
}