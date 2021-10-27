package LC0033;

/**
 * 搜索旋转数组
 * 为什么要 while (i <= j)?
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int i = 0, j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && nums[mid] >= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}