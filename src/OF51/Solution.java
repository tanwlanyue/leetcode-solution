package OF51;

/**
 * 逆序对
 * 当左指针移动时计算逆序对
 * @author zhanglei211 on 2021/10/19.
 */
class Solution {
    int num = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        merge(nums, 0, nums.length - 1);
        return num;
    }

    private void merge(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = (i + j) / 2;
        merge(nums, i, mid);
        merge(nums, mid + 1, j);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums, i, temp, i, j - i + 1);
        int m = i, n = mid + 1;
        int k = i;
        while (m <= mid && n <= j) {
            if (temp[m] <= temp[n]) {
                num += n - 1 - (mid + 1) + 1;
                nums[k++] = temp[m++];
            } else {
                nums[k++] = temp[n++];
            }
        }
        while (n <= j) {
            nums[k++] = temp[n++];
        }

        while (m <= mid) {
            num += j - (mid + 1) + 1;
            nums[k++] = temp[m++];
        }
    }
}