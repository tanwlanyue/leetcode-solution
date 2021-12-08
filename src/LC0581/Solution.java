package LC0581;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1, right = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                left = i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}