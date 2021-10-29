package LC0041;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean[] exist = new boolean[length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 1 && num <= length) {
                exist[num - 1] = true;
            }
        }
        int num = -1;
        for (int i = 0; i < exist.length; i++) {
            if (!exist[i]) {
                num = i + 1;
                break;
            }
        }
        return num == -1 ? length + 1 : num;
    }
}