package LC0315;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * TODO
 * 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * @author zhanglei211 on 2021/11/30.
 */
class Solution {
    int[] index;
    int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        this.index = index;
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }

    private void mergeSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        System.arraycopy(nums, i, temp, i, j - i + 1);
        int mid = (i + j) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        int m = i, n = mid + 1;
        int k = i;
        while (m <= mid && n <= j) {
            if (temp[m] <= temp[n]) {
                nums[k] = temp[m];
                index[m] = k;
                m++;
                k++;
            } else {
                nums[k++] = temp[n];
                index[n] = k;
                n++;
                k++;
            }
        }
        while (m <= mid) {
            nums[k] = temp[m];
            index[m] = k;
            m++;
            k++;
        }
        while (n <= j) {
            nums[k] = temp[n];
            index[n] = k;
            n++;
            k++;
        }

    }
}