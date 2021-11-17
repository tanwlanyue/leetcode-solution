package OF29;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row==0){
            return new int[]{};
        }
        int col = matrix[0].length;
        if(col==0){
            return new int[]{};
        }
        int total = row * col;
        int[] res = new int[total];

        int index = 0;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (total > 0) {
            for (int i = left; i <= right && total > 0; i++) {
                res[index++] = matrix[top][i];
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total > 0; i++) {
                res[index++] = matrix[i][right];
                total--;
            }
            right--;
            for (int i = right; i >= left && total > 0; i--) {
                res[index++] = matrix[bottom][i];
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total > 0; i--) {
                res[index++] = matrix[i][left];
                total--;
            }
            left++;
        }
        return res;
    }
}