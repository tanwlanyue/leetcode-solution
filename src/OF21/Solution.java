package OF21;

/**
 * @author zhanglei211 on 2021/11/10.
 */
class Solution {
    public int[] exchange(int[] nums) {

        int length = nums.length;
        int i = 0, j = length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}