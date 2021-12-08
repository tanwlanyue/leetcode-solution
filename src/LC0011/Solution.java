package LC0011;

/**
 * 11. 盛最多水的容器 </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 67.13% 的用户 </br>
 * 内存消耗： 51.9 MB , 在所有 Java 提交中击败了 45.21% 的用户
 * 
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}