package LC0525;

import java.util.HashMap;

/**
 * TODO
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 前缀和+哈希表
 * @author zhanglei211 on 2021/10/8.
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            for (int j = length - 1; j >= 0; j--) {
                if ((j - i) % 2 == 1) {
                    if (map.containsKey((j - i + 1) / 2 - sum)) {
                        maxLen = Math.max(maxLen, j - i + 1);
                        break;
                    }
                }
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }
}