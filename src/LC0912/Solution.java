package LC0912;

import java.util.Random;

/**
 * @author zhanglei211 on 2021/9/11.
 */
class Solution {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        sortArray(nums, 0, length - 1);
        return nums;
    }

    public void sortArray(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        sortArray(nums, left, p - 1);
        sortArray(nums, p + 1, right);
    }

    private int partition(int[] nums, int i, int j) {
        int random = i + new Random().nextInt(j - i + 1);
        swap(nums, i, random);
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