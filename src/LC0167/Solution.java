package LC0167;

/**
 * @author zhanglei211 on 2021/11/24.
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int i = 0, j = length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {};
    }
}