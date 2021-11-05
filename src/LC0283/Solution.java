package LC0283;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        while (p < length) {
            nums[p++] = 0;
        }
    }
}