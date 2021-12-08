package LC0399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 除法求值 带权有向图
 * 
 * @author zhanglei211 on 2021/9/24.
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!map.containsKey(a)) {
                map.put(a, id);
                id++;
            }
            if (!map.containsKey(b)) {
                map.put(b, id);
                id++;
            }
            unionFind.union(map.get(a), map.get(b), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Integer id1 = map.get(a);
            Integer id2 = map.get(b);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         * 
         * @param x
         * @return
         */
        public int findParent(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = findParent(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if (parentX == parentY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}