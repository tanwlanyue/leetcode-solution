package LC0240;

/**
 * 240. 搜索二维矩阵 II </br>
 * 执行用时： 5 ms , 在所有 Java 提交中击败了 98.35% 的用户 </br>
 * 内存消耗： 43.5 MB , 在所有 Java 提交中击败了 84.28% 的用户
 * 
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}