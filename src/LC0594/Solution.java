package LC0594;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                int sum = entry.getValue() + map.getOrDefault(entry.getKey() + 1, 0);
                maxLen = Math.max(maxLen, sum);
            }
        }
        return maxLen;
    }
}