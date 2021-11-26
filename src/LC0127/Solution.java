package LC0127;

import java.util.*;

/**
 * @author zhanglei211 on 2021/10/26.
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        int minLen = Integer.MAX_VALUE;
        int endWordIndex = wordList.indexOf(endWord);
        if (endWordIndex == -1) {
            return 0;
        }
        ArrayList<Integer>[] edge = new ArrayList[length];
        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    edge[i].add(j);
                    edge[j].add(i);
                }
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            HashSet<Integer> set = new HashSet();
            if (check(beginWord, wordList.get(i))) {
                set.add(i);
                int len = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    len++;
                    for (int j = 0; j < size; j++) {
                        Integer poll = queue.poll();
                        if (poll == endWordIndex) {
                            minLen = Math.min(minLen, len);
                        }
                        for (Integer integer : edge[poll]) {
                            if (set.add(integer)) {
                                queue.add(integer);
                            }
                        }
                    }
                }

            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private boolean check(String s, String t) {
        int diff = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (++diff >= 2) {
                    return false;
                }
            }
        }
        return true;
    }
}