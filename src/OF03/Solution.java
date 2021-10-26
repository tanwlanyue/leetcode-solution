package OF03;

import java.util.HashSet;

/**
 * @author zhanglei211 on 2021/10/25.
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                int num = nums[i];
                if (nums[num] == num) {
                    return num;
                } else {
                    swap(nums, i, num);
                }
            }
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}