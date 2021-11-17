package LC0442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                list.add(num);
            }
        }
        return list;
    }
}