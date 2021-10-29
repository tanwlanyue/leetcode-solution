package LC0239;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                int pollIndex = i - k;
                Integer poll = queue.getFirst();
                if (pollIndex >= poll) {
                    queue.pollFirst();
                }
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}