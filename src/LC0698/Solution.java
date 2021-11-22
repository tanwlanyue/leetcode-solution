package LC0698;

/**
 * TODO
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int singleSum = sum / k;
        for (int num : nums) {
            if (num > singleSum) {
                return false;
            }
        }
        return false;
    }
}