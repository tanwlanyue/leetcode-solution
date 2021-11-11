package LC0560;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        // 前缀和为key的个数为value
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}