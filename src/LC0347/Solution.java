package LC0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}