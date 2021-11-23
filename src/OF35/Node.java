package OF35;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}