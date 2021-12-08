package LC0071;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * TODO
 * @author zhanglei211 on 2021/12/1.
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] ops = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            count++;
            for (int[] op : ops) {
                int i = poll.getKey() + op[0];
                int j = poll.getValue() + op[1];
                if (i < 0 || i >= m || j < 0 || j >= n || !valid(i, j, k) || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                queue.add(new Pair<>(i, j));
            }
        }
        return count;
    }

    private boolean valid(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum <= k;
    }

}