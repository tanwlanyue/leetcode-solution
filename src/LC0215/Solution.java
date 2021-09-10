package LC0215;

import java.util.Random;

/**
 * ⭐️⭐️⭐️ 数组中的第K个最大元素
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        int targetPos = nums.length - k;
        int i = 0, j = nums.length - 1;
        while (true) {
            int p = partition(nums, i, j);
            if (p > targetPos) {
                // 不要忘记-1 +1
                j = p - 1;
            } else if (p < targetPos) {
                i = p + 1;
            } else {
                return nums[targetPos];
            }
        }
    }

    /**
     * 已左边的数为参考，先从右往左 再从左往右
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public int partition(int[] nums, int i, int j) {
        int random = i + new Random().nextInt(j - i + 1);
        swap(nums, random, j);
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            swap(nums, i, j);
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            swap(nums, i, j);
        }
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
