package LC0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/22.
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int m = j + 1, n = length - 1;
                        int t = target - nums[i] - nums[j];
                        while (m < n) {
                            int sum = nums[m] + nums[n];
                            if (sum > t) {
                                while (m < n && nums[n] == nums[--n]) {
                                }

                            } else if (sum < t) {
                                while (m < n && nums[m] == nums[++m]) {
                                }

                            } else {
                                ArrayList<Integer> list =
                                        new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                                res.add(list);
                                while (m < n && nums[m] == nums[++m]) {
                                }

                                while (m < n && nums[n] == nums[--n]) {
                                }

                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}