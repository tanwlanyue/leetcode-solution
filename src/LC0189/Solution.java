package LC0189;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int leftCount = length - k % length;
        reverse(nums, 0, leftCount - 1);
        reverse(nums, leftCount, length - 1);
        reverse(nums, 0, length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}