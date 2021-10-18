package LC0031;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/10/18.
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int l = 0;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                l = i;
                break;
            }
        }
        if (l == 0) {
            Arrays.sort(nums);
        } else {
            int num = nums[l - 1];
            for (int i = length - 1; i >= 1; i--) {
                if (nums[i] > num) {
                    swap(nums, i, l - 1);
                    break;
                }
            }
            int left = l, right = length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}