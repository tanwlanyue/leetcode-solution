package LC0045;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int step = 0;
        int canReach = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            canReach = Math.max(i + nums[i], canReach);
            if (i == end) {
                end = canReach;
                step++;
            }
        }
        return step;
    }
}