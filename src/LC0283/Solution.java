package LC0283;

/**
 * 283. 移动零 </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 82.27% 的用户 </br>
 * 内存消耗： 39 MB , 在所有 Java 提交中击败了 78.29% 的用户
 * 
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int w = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[w++] = nums[i];
            }
        }
        while (w < length) {
            nums[w++] = 0;
        }
    }
}