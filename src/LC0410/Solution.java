package LC0410;

/**
 * TODO
 * @author zhanglei211 on 2021/11/26.
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int[] sum = new int[length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        return 0;
    }
}