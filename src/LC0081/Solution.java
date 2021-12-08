package LC0081;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int i = 0, j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[j]) {
                if (nums[mid] <= target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] == nums[j]) {
                j--;
            } else {
                if (nums[i] <= target && target <= nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return false;
    }
}