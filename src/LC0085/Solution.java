package LC0085;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        int[] heights = new int[col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, calMaxArea(heights));
        }
        return maxArea;
    }

    private int calMaxArea(int[] heights) {
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                Integer pop = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[pop] * (i - left - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek();
            int area = heights[pop] * (right - left - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}