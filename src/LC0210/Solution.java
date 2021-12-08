package LC0210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 * 
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(cur);
            inDegree[cur]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ret = new int[numCourses];
        int r = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ret[r++] = poll;
            if (map.get(poll) != null) {
                for (Integer child : map.get(poll)) {
                    if (--inDegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        if (r == numCourses) {
            return ret;
        }
        return new int[] {};
    }
}