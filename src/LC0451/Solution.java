package LC0451;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        PriorityQueue<Pair<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                heap.add(new Pair<>((char) i, count[i]));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!heap.isEmpty()) {
            Pair<Character, Integer> poll = heap.poll();
            int time = poll.getValue();
            Character c = poll.getKey();
            for (int i = 0; i < time; i++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}