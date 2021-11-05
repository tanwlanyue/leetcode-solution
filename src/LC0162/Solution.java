package LC0162;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        } else if (length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int i = 0, j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else if (mid == length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    i = mid + 1;
                } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    j = mid - 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return i;
    }
}