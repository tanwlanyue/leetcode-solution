package LC0674;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                maxLen = Math.max(count, maxLen);
                count = 1;
            }
            if (i == nums.length - 1) {
                maxLen = Math.max(count, maxLen);
            }
        }
        return maxLen;
    }
}