package OF61;

import java.util.HashSet;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                if (!set.add(num)) {
                    return false;
                }
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }
        return max - min <= 4;
    }
}