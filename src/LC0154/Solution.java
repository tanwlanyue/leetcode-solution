package LC0154;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int i = 0, j = length - 1;
        int min = nums[0];
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < nums[j]) {
                min = Math.min(min, nums[mid]);
                j = mid - 1;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                min = Math.min(min, nums[j]);
                j--;
            }
        }
        return min;
    }
}