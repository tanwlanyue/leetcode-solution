package LC0785;

/**
 * 
 * 785. 判断二分图 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 98.43% 的用户
 * 
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int start = 0;
        int[] mark = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (mark[i] == 0 && !dfs(i, graph, mark, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int start, int[][] graph, int[] mark, int color) {
        if (mark[start] == 0) {
            mark[start] = color;
        } else {
            return mark[start] == color;
        }
        color = -color;
        for (int end : graph[start]) {
            if (!dfs(end, graph, mark, color)) {
                return false;
            }
        }
        return true;
    }

}