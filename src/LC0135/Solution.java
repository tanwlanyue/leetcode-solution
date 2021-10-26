package LC0135;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/10/26.
 */
class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int sum = left[length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}