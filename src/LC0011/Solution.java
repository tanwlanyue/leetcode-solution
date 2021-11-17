package LC0011;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int i = 0, j = length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}