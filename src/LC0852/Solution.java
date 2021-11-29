package LC0852;

/**
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int i = 0, j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (mid == 0) {
                i++;
            } else if (mid == length - 1) {
                j--;
            } else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] >= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
                    i = mid + 1;
                } else if (arr[mid] <= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}