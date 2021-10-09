package LC0136;

/**
 * @author zhanglei211 on 2021/10/9.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
}