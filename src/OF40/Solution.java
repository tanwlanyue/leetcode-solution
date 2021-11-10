package OF40;

import java.util.Random;

/**
 * @author zhanglei211 on 2021/11/10.
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (k == 0) {
            return new int[] {};
        }
        if (k > arr.length) {
            return arr;
        }
        int i = 0, j = length - 1;
        while (true) {
            int p = partition(arr, i, j);
            if (p+1==k) {
                int[] res = new int[k];
                for (int m = 0; m < k; m++) {
                    res[m] = arr[m];
                }
                return res;
            } else if (p +1> k) {
                j = p - 1;
            } else {
                i = p + 1;
            }
        }
    }

    private int partition(int[] arr, int i, int j) {
        int random = new Random().nextInt(j - i + 1) + i;
        swap(arr, i, random);
        int pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            swap(arr, i, j);
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            swap(arr, i, j);
        }
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}