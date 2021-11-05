package LC0498;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int total = row * col;
        int[] res = new int[total];
        int p = 0;
        for (int level = 1; level < row + col; level++) {
            if ((level % 2) == 1) {
                if (level <= row) {
                    int i = level - 1, j = 0;
                    while (i >= 0 && j < col) {
                        res[p++] = mat[i--][j++];
                    }
                } else {
                    int i = row - 1, j = level - row;
                    while (i >= 0 && j < col) {
                        res[p++] = mat[i--][j++];
                    }
                }
            } else {
                if (level <= col) {
                    int i = 0, j = level - 1;
                    while (i < row && j >= 0) {
                        res[p++] = mat[i++][j--];
                    }
                } else {
                    int i = level - col, j = col - 1;
                    while (i < row && j >= 0) {
                        res[p++] = mat[i++][j--];
                    }
                }
            }
        }
        return res;
    }
}