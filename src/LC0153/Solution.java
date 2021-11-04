package LC0153;

/**
 * @author zhanglei211 on 2021/11/2.
 */
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1;
        int min = nums[0];
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > nums[i]) {
                min = Math.min(min, nums[i]);
                i = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                j = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{2,1}));
    }
}