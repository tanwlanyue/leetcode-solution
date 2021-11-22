package LC0540;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                i = mid + 2;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
}