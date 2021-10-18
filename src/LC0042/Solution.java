package LC0042;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/10/18.
 */
class Solution {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                Integer cur = stack.pop();
                Integer l = stack.peek();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[l]) - height[cur];
                    int w = i - l - 1;
                    area += h * w;
                }
            }
            stack.push(i);
        }
        return area;
    }
}