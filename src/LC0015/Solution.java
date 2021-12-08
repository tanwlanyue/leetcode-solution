package LC0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和 </br>
 * 执行用时： 20 ms , 在所有 Java 提交中击败了 84.76% 的用户 </br>
 * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 48.63% 的用户
 * 
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int a = nums[i];
            if (a > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = length - 1;
            while (j < k) {
                int b = nums[j], c = nums[k];
                int sum = a + b + c;
                if (sum == 0) {
                    lists.add(new ArrayList<>(Arrays.asList(a, b, c)));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return lists;
    }
}