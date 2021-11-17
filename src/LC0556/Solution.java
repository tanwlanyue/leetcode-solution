package LC0556;

/**
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;
        int[] nums = new int[length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }
        if (length == 1) {
            return -1;
        }
        int leftIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                leftIndex = i;
                break;
            }
        }
        if (leftIndex == -1) {
            return -1;
        }
        int num = nums[leftIndex];
        for (int i = length - 1; i >= leftIndex+1; i--) {
            if (nums[i] > num) {
                swap(nums, leftIndex, i);
                reverse(nums, leftIndex + 1, length - 1);
                break;
            }

        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res * 10 + nums[i];
        }
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}