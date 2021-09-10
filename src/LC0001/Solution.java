package LC0001;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valPosMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (valPosMap.containsKey(minus)) {
                return new int[] { valPosMap.get(minus), i };
            }
            valPosMap.put(nums[i], i);
        }
        return new int[2];
    }
}
