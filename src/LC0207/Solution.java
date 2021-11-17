package LC0207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * prerequisite[0] cur prerequisite[1] pre
 * 
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    //
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] targetArr = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            ArrayList<Integer> list = map.get(pre);
            if (list == null) {
                list=new ArrayList<>();
                map.put(pre, list);
            }
            list.add(cur);
            targetArr[cur]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < targetArr.length; i++) {
            if (targetArr[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            ArrayList<Integer> list = map.get(poll);
            if (list != null) {
                for (Integer integer : list) {
                    if (--targetArr[integer] == 0) {
                        queue.add(integer);
                    }
                }
            }
        }
        return count == numCourses;
    }
}