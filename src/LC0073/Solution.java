package LC0073;

/**
 * 矩阵置零
 * 1. 先获得0行和0列的是否有0 得到两个boolean 决定了 0行 0列的命运
 * 2. 再扫描除0行0列 以外的所有格子 m-1 * n-1  更新0行和0列的信息
 * 3. 通过0行0列信息 更新格子 m-1 * n-1 的状态
 * 4. 最后通过两个boolean 决定了 0行 0列的状态
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return;
        }

        boolean col0HasZero = false;
        boolean row0HasZero = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0HasZero = true;
                break;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0HasZero = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (col0HasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0HasZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}