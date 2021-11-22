package LC0523;

import java.util.HashMap;

/**
 * 前缀和+哈希表
 * TODO
 * @author zhanglei211 on 2021/10/8.
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            int mod = sum % k;
            if (mod == 0 || (map.containsKey(mod) && i - map.get(mod) > 1)) {
                return true;
            }
            map.putIfAbsent(mod, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[] { 5, 0, 0, 0 }, 3));
    }
}