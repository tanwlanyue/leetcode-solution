package LC0016;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int minus = Integer.MAX_VALUE;
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1, k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    int curMinus = sum - target;
                    if (curMinus < minus) {
                        minus = curMinus;
                        closestSum = sum;
                    }
                    k--;
                } else {
                    int curMinus = target - sum;
                    if (curMinus < minus) {
                        minus = curMinus;
                        closestSum = sum;
                    }
                    j++;
                }
            }
        }
        return closestSum;
    }
}