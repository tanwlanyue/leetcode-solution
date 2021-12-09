package LC0210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 210. 课程表 II </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 77.93% 的用户 </br>
 * 内存消耗： 39 MB , 在所有 Java 提交中击败了 97.77% 的用户
 * 
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] child = new ArrayList[numCourses];
        for (int i = 0; i < child.length; i++) {
            child[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            child[pre].add(cur);
            inDegree[cur]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] arr = new int[numCourses];
        int w = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            arr[w++] = poll;
            for (Integer i : child[poll]) {
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return w == numCourses ? arr : new int[] {};
    }
}