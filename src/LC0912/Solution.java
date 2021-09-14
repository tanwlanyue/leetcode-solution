package LC0912;

/**
 * ⭐️⭐️⭐️堆排序
 *
 * @author zhanglei211 on 2021/9/11.
 */
class Solution {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heapify(nums);
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移  从有孩子节点的最后一个开始
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            // j左孩子
            int j = 2 * k + 1;
            // j+1右孩子
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            // 向下判断
            k = j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // public int[] sortArray(int[] nums) {
    // int length = nums.length;
    // sortArray(nums, 0, length - 1);
    // return nums;
    // }
    //
    // public void sortArray(int[] nums, int left, int right) {
    // if (left >= right) {
    // return;
    // }
    // int p = partition(nums, left, right);
    // sortArray(nums, left, p - 1);
    // sortArray(nums, p + 1, right);
    // }
    //
    // private int partition(int[] nums, int i, int j) {
    // int random = i + new Random().nextInt(j - i + 1);
    // swap(nums, i, random);
    // int pivot = nums[i];
    // while (i < j) {
    // while (i < j && nums[j] >= pivot) {
    // j--;
    // }
    // swap(nums, i, j);
    // while (i < j && nums[i] <= pivot) {
    // i++;
    // }
    // swap(nums, i, j);
    // }
    // return i;
    // }
    //
    // public void swap(int[] nums, int i, int j) {
    // int temp = nums[i];
    // nums[i] = nums[j];
    // nums[j] = temp;
    // }
}