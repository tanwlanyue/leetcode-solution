package LC0448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i]-1) % n;
            nums[index] += n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}