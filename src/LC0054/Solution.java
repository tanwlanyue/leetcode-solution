package LC0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 注意 while (total > 0)
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (total > 0) {
            for (int i = left; i <= right && total >= 0; i++) {
                list.add(matrix[top][i]);
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total >= 0; i++) {
                list.add(matrix[i][right]);
                total--;
            }
            right--;
            for (int i = right; i >= left && total >= 0; i--) {
                list.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total >= 0; i--) {
                list.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return list;
    }
}