package LC0169;

/**
 * @author zhanglei211 on 2021/9/17.
 */
class Solution {
    public int majorityElement(int[] nums) {
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    prev = nums[i];
                    count = 1;
                }
            }
        }
        return prev;
    }
}