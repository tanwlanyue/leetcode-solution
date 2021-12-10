package LC0684;

/**
 * 684. 冗余连接 </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 65.66% 的用户 </br>
 * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 95.13% 的用户
 * 
 * @author zhanglei211 on 2021/12/8.
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 3;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] ret = new int[] {};
        for (int[] edge : edges) {
            int parent1 = findParent(parent, edge[0]);
            int parent2 = findParent(parent, edge[1]);
            if (parent1 > parent2) {
                parent1 = parent1 ^ parent2;
                parent2 = parent1 ^ parent2;
                parent1 = parent1 ^ parent2;
            }
            if (parent[parent1] == parent2) {
                ret = edge;
            } else {
                parent[parent1] = parent2;
            }
        }
        return ret;
    }

    private int findParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }
}