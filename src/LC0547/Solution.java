package LC0547;

/**
 * 并查集 也可用dfs
 * 
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {

    private int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    /**
     * 合并两个节点，两个节点的parent关联在一起
     * 
     * @param index1
     * @param index2
     */
    public void union(int index1, int index2) {
        parent[find(index1)] = find(index2);
    }

    /**
     * 更新index的parent,并返回
     * 
     * @param index
     * @return
     */
    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    // public int findCircleNum(int[][] isConnected) {
    // int n = isConnected.length;
    // int count = 0;
    // boolean[] visited = new boolean[n];
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // if (isConnected[i][j] == 1 && !visited[i]) {
    // dfs(isConnected, i, visited);
    // count++;
    // }
    // }
    // }
    // return count;
    // }
    //
    // private void dfs(int[][] isConnected, int i, boolean[] visited) {
    // int n = isConnected.length;
    // for (int j = 0; j < n; j++) {
    // if (isConnected[i][j] == 1 && !visited[j]) {
    // visited[j] = true;
    // dfs(isConnected, j, visited);
    // }
    // }
    // }

}
