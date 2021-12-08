package LC0002;

/**
 * 2. 两数相加 <br/>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 56.31% 的用户
 * 
 * @author zhanglei211 on 2021/10/21.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = 0, l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}