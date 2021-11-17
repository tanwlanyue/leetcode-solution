package LC0670;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = chars[i] - '0';
        }
        int scanIndex = length;
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[i - 1]) {
                scanIndex = i;
                break;
            }
        }
        if (scanIndex == length) {
            return num;
        }

        int right = scanIndex;
        for (int i = scanIndex; i < length; i++) {
            if (arr[i] >= arr[right]) {
                right = i;
            }
        }
        int rightMax = arr[right];

        for (int i = 0; i < scanIndex; i++) {
            if (arr[i] < rightMax) {
                swap(arr, i, right);
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i);
        }
        return Integer.parseInt(builder.toString());
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        new Solution().maximumSwap(43456);
    }
}