package LC0027;

/**
 * @author zhanglei211 on 2021/12/7.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[w++] = nums[i];
            }
        }
        return w;
    }
}