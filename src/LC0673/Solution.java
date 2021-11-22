package LC0673;

/**
 * TODO 最长递增子序列的个数
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 1;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[maxLen]) {
                dp[++maxLen] = nums[i];
            } else {
                int offset = 0;
                int m = 0, n = maxLen;
                while (m <= n) {
                    int mid = (m + n) / 2;
                    if (dp[mid] >= nums[i]) {
                        n--;
                    } else {
                        offset = mid;
                        m++;
                    }
                }
                dp[offset + 1] = nums[i];
            }
        }
        return 0;
    }
}