package LC0977;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        int index = length - 1;
        int i = 0, j = length - 1;
        while (i <= j) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left >= right) {
                arr[index--] = left;
                i++;
            } else {
                arr[index--] = right;
                j--;
            }
        }
        return arr;
    }
}