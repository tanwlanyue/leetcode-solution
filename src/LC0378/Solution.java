package LC0378;

/**
 * 378. 有序矩阵中第 K 小的元素 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 43.6 MB , 在所有 Java 提交中击败了 74.34% 的用户
 * 
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int a = matrix[0][0];
        int b = matrix[n - 1][n - 1];
        int num = a;
        while (a <= b) {
            int mid = (a + b) / 2;
            if (getLessOrEqualsCount(matrix, k, mid, n) >= k) {
                num = mid;
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }
        return num;
    }

    private int getLessOrEqualsCount(int[][] matrix, int k, int mid, int n) {
        int i = n - 1, j = 0;
        int cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }
}