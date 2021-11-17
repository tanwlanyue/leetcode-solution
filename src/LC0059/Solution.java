package LC0059;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] arr = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 0;
        while (total > 0) {
            for (int i = left; i <= right && total > 0; i++) {
                arr[top][i] = ++count;
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total > 0; i++) {
                arr[i][right] = ++count;
                total--;
            }
            right--;
            for (int i = right; i >= left && total > 0; i--) {
                arr[bottom][i] = ++count;
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total > 0; i--) {
                arr[i][left] = ++count;
                total--;
            }
            left++;
        }
        return arr;
    }
}