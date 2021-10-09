package LC0260;

/**
 * 异或分组
 * @author zhanglei211 on 2021/10/9.
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int b = 1;
        while ((b & xor) == 0) {
            b = b << 1;
        }
        int i = 0, j = 0;
        for (int num : nums) {
            if ((num & b) == 0) {
                i = i ^ num;
            } else {
                j = j ^ num;
            }
        }
        return new int[] { i, j };
    }
}