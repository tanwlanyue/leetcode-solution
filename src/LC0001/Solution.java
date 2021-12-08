package LC0001;

import java.util.HashMap;

/**
 * 1. 两数之和 </br>
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 88.08% 的用户 </br>
 * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 55.00% 的用户
 * 
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] { map.get(key), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}