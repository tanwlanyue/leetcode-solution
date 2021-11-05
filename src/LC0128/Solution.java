package LC0128;

import java.util.HashMap;

/**
 * 最长连续序列 法1：hashset 法2：先排序 法3：hashmap 更新端点
 * 
 * @author zhanglei211 on 2021/11/3.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int total = left + right + 1;
                max = Math.max(max, total);
                map.put(num, total);
                map.put(num - left, total);
                map.put(num + right, total);

            }
        }
        return max;
    }
}