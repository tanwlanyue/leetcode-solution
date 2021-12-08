package LC0743;

import java.util.*;

/**
 * TODO
 * 
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        k = k - 1;
        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            graph[u][v] = w;
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;





        int max = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, distance[i]);
        }
        return max;
    }

}