package LC0034;

/**
 * @author zhanglei211 on 2021/11/2.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    private int findLast(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int last = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] == target) {
                last = mid;
                i = mid + 1;
            } else {
                i = mid+ 1;
            }

        }
        return last;
    }

    private int findFirst(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int first = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] == target) {
                first = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return first;
    }
}