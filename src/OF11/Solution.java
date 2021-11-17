package OF11;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public int minArray(int[] numbers) {
        int length = numbers.length;
        int i = 0, j = length - 1;
        int min = numbers[0];
        while (i <= j) {
            int mid = (i + j) / 2;
            if (numbers[mid] < numbers[j]) {
                min = Math.min(numbers[mid], min);
                j = mid - 1;
            } else if (numbers[mid] == numbers[j]) {
                min = Math.min(numbers[j], min);
                j--;
            } else {
                i = mid + 1;
            }
        }
        return min;
    }
}