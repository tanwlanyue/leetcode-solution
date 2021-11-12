package LC0026;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int w = 1, r = 1;
        while (r < length) {
            if (nums[r] != nums[r - 1]) {
                nums[w++] = nums[r];
            }
            r++;
        }
        return w;
    }
}