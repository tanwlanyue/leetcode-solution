package LC0066;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 46.85% 的用户
 * 
 * @author zhanglei211 on 2021/12/1.
 */
class Solution {
    /**
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int digit : digits) {
            if (digit != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] arr = new int[digits.length + 1];
            Arrays.fill(arr, 0);
            arr[0] = 1;
            return arr;
        }
        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + plus + (i == digits.length - 1 ? 1 : 0);
            digits[i] = sum % 10;
            plus = sum / 10;
        }
        return digits;
    }
}