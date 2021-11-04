package LC0240;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}