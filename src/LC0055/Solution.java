package LC0055;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int canReach = 0;
        for (int i = 0; i <= canReach; i++) {
            canReach = Math.max(i + nums[i], canReach);
            if (canReach >= length - 1) {
                return true;
            }
        }
        return canReach >= length - 1;
    }
}