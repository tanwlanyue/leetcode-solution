package LC0268;

/**
 * @author zhanglei211 on 2021/10/9.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = n;
        for (int i = 0; i < n; i++) {
            x = x ^ nums[i] ^ i;
        }
        return x;
    }
}