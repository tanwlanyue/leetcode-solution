package LC0238;

/**
 * @author zhanglei211 on 2021/10/26.
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int a = 1;
        for (int i = 0; i < length; i++) {
            res[i] = a;
            a *= nums[i];
        }
        int b = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] *= b;
            b *= nums[i];
        }
        return res;
    }
}
