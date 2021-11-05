package OF36;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (head == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        inOrder(root.right);
    }
}