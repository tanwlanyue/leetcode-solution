package LC0503;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[] { 1, 2, 1 });
    }
}