package OF35;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = head;
        while (dummy != null) {
            Node next = dummy.next;
            Node newNode = new Node(dummy.val);
            newNode.next = next;
            dummy.next = newNode;
            dummy = next;
        }
        dummy = head;
        while (dummy != null) {
            Node next = dummy.next.next;
            Node newNode = dummy.next;
            if (dummy.random != null) {
                newNode.random = dummy.random.next;
            }
            dummy = next;
        }
        Node oldNode = head;
        Node newHead = head.next;
        Node newNode = newHead;
        head = head.next.next;
        while (head != null) {
            oldNode.next = head;
            newNode.next = head.next;
            oldNode = oldNode.next;
            newNode = newNode.next;
            head = head.next.next;
        }
        oldNode.next = null;
        return newHead;
    }
}