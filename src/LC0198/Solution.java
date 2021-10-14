package LC0198;

/**
 * @author zhanglei211 on 2021/10/14.
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        // dp[i] 前i天最大偷窃
        int[] dp = new int[length];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                dp[0]=nums[0];
            }else if(i==1){
                dp[1]=Math.max(nums[0],nums[1]);
            }else {
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }
        return dp[length-1];
    }
//    public int rob(int[] nums) {
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        }
//        if (length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        int max = 0;
//        int[][] dp = new int[length][2];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                dp[0][0] = 0;
//                dp[0][1] = nums[0];
//            } else if (i == 1) {
//                dp[1][0] = nums[0];
//                dp[1][1] = nums[1];
//            } else {
//                dp[i][1] = dp[i - 1][0] + nums[i];
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            }
//            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
//        }
//        return max;
//    }
}