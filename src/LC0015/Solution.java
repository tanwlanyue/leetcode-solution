package LC0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    /**
     * while (j < k && nums[j] == nums[++j]){}; 去重，写括号里面要注意的话要注意别死循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[++j]){};
                    while (j < k && nums[k] == nums[--k]){};
                } else if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]){};
                } else {
                    while (j < k && nums[j] == nums[++j]){};
                }
            }

        }
        return res;
    }
}
