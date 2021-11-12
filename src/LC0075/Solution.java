package LC0075;

/**
 * 颜色分类
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left++, i);
                i++;
            } else if (nums[i] == 2) {
                swap(nums, right--, i);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}