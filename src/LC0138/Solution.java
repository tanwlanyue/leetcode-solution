package LC0138;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = head;
        while (dummy != null) {
            Node next = dummy.next;
            Node newNode = new Node(dummy.val);
            dummy.next = newNode;
            newNode.next = next;
            dummy = next;
        }
        dummy = head;
        while (dummy != null) {
            Node newNode = dummy.next;
            if (dummy.random != null) {
                newNode.random = dummy.random.next;
            }
            dummy = dummy.next.next;
        }

        Node newHead = new Node(-1);
        Node newNode = newHead;
        while (head != null) {
            Node next = head.next.next;
            newNode.next=head.next;
            newNode=newNode.next;
            head.next = next;
            head = next;
        }
        return newHead.next;
    }

}