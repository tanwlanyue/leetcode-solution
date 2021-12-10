package LC0540;

/**
 * 540. 有序数组中的单一元素 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 43.9 MB , 在所有 Java 提交中击败了 5.05% 的用户
 * 
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {

    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (mid % 2 == 1) {
                mid = mid - 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                i = mid + 2;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
}