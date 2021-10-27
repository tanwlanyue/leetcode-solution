package LC0300;

/**
 * 最长递增子序列 注意dp[i]的定义
 * 
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // dp[i] 长度为i序列的最小结尾
        int[] dp = new int[length + 1];
        dp[1] = nums[0];
        int maxLen = 1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num > dp[maxLen]) {
                dp[++maxLen] = num;
            } else {
                // 找到最后一个比她小的 替换后一个
                int base = 0;
                int m = 1, n = maxLen;
                while (m <= n) {
                    int mid = (m + n) / 2;
                    if (dp[mid] >= num) {
                        n = mid - 1;
                    } else {
                        base = mid;
                        m = mid + 1;
                    }
                }
                int index = base + 1;
                dp[index] = num;
            }
        }
        return maxLen;
    }
}