package LC0237;

/**
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
}