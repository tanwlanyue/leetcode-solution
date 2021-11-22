package LC0692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                .sorted((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue())
                .collect(Collectors.toList());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(collect.get(i).getKey());
        }
        return list;
    }
}