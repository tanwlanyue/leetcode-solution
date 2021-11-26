package LC1091;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * BFS
 * @author zhanglei211 on 2021/11/23.
 */
class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] ops = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(0, 0));
        int row = grid.length;
        int col = grid[0].length;
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> poll = queue.poll();
                if (poll.getKey() == row - 1 && poll.getValue() == col - 1) {
                    return len;
                }
                for (int[] op : ops) {
                    int m = poll.getKey() + op[0];
                    int n = poll.getValue() + op[1];
                    if (m < 0 || m >= row || n < 0 || n >= col || grid[m][n] == 1) {
                        continue;
                    }
                    grid[m][n] = 1;
                    queue.add(new Pair<>(m, n));
                }
            }
        }
        return -1;
    }
}