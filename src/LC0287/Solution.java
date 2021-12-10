package LC0287;

/**
 * 287. 寻找重复数 </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 94.56% 的用户 </br>
 * 内存消耗： 53.7 MB , 在所有 Java 提交中击败了 87.47% 的用户
 * 
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}