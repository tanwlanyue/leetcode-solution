package LC0304;

/**
 * @author zhanglei211 on 2021/11/26.
 */
class NumMatrix {
    int[][] sumTable;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sumTable = new int[row][col];
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
                sumTable[i][j] = (i == 0 ? 0 : sumTable[i - 1][j]) + sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum = sumTable[row2][col2] - (col1 == 0 ? 0 : sumTable[row2][col1 - 1])
                - (row1 == 0 ? 0 : sumTable[row1 - 1][col2])
                + ((row1 == 0 || col1 == 0) ? 0 : sumTable[row1 - 1][col1 - 1]);
        return sum;
    }
}