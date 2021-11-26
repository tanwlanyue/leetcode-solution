package LC0611;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/26.
 */
class Solution {
    int count = 0;

    public int triangleNumber(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < length; j++) {
                int num2 = nums[j];
                int k = length - 1;
                while (k > j && num1 + num2 < nums[k]) {
                    k--;
                }
                count += k - j;
            }
        }
        return count;
    }
}