package LC0209;

/**
 * @author zhanglei211 on 2021/11/8.
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int minLen = nums.length + 1;
        int length = nums.length;
        int sum = 0;
        while (j < length) {
            sum += nums[j];
            j++;
            while (sum >= target && i < j) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i++;
            }

        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}