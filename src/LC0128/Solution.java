package LC0128;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 最长连续序列
 * 法1：hashmap
 * 法2：先排序
 * @author zhanglei211 on 2021/11/3.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (!set.contains(num - 1)) {
                int len = 0;
                while (set.contains(num++)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}