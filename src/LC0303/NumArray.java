package LC0303;

/**
 * @author zhanglei211 on 2021/10/14.
 */
class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        int length = nums.length;
        dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return dp[right];
        } else {
            return dp[right] - dp[left - 1];
        }
    }
}