package LC0217;

import java.util.HashSet;

/**
 * @author zhanglei211 on 2021/10/9.
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}