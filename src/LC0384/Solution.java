package LC0384;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {

    int[] backup;
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.backup = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        this.nums = this.backup;
        this.backup = Arrays.copyOf(nums, nums.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int toIndex = randomInRange(i, nums.length);
            swap(nums, i, toIndex);
        }
        return nums;
    }

    private int randomInRange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
