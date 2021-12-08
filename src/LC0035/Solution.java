package LC0035;

/**
 * 35. 搜索插入位置 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38 MB , 在所有 Java 提交中击败了 55.05% 的用户
 * 
 * @author zhanglei211 on 2021/12/2.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mark = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                mark = mid;
                i = mid + 1;
            }
        }
        return mark + 1;
    }
}