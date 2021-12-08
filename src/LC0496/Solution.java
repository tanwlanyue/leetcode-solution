package LC0496;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int curVal = nums2[i];
            while (!stack.isEmpty() && curVal > nums2[stack.peek()]) {
                Integer poll = stack.poll();
                map.put(nums2[poll], curVal);
            }
            stack.push(i);
        }
        int length = nums1.length;
        int[] ret = new int[length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = map.getOrDefault(nums1[i], -1);
        }
        return ret;
    }
}