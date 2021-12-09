package LC0503;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 503. 下一个更大元素 II </br>
 * 执行用时： 5 ms , 在所有 Java 提交中击败了 95.77% 的用户 </br>
 * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 45.56% 的用户
 * 
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        Arrays.fill(arr, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                arr[pop] = nums[index];
            }
            stack.push(index);
        }
        return arr;
    }
}