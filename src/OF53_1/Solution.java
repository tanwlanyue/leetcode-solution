package OF53_1;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int i = 0, j = length - 1;
        int left = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                left = mid;
                j = mid - 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (left == -1) {
            return 0;
        }
        int right = -1;
        i = 0;
        j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                right = mid;
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return right - left + 1;
    }
}