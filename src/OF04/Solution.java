package OF04;

/**
 * @author zhanglei211 on 2021/10/25.
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
            return false;
        }
        int col = matrix[0].length;
        if(col==0){
            return false;
        }
        int i = row - 1, j = 0;
        while (i >= 0 && j <= col - 1) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}