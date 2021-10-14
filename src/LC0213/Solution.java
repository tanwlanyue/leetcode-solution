package LC0213;

/**
 * @author zhanglei211 on 2021/10/14.
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = rob(nums, 0, length - 2);
        int b = rob(nums, 1, length - 1);
        return Math.max(a, b);
    }

    public int rob(int[] nums, int start, int end) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[start] = nums[start];
            } else if (i == start + 1) {
                dp[start + 1] = Math.max(nums[start], nums[start + 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[end];
    }
}