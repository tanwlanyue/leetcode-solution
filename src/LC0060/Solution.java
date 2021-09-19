package LC0060;

import java.util.ArrayList;
import java.util.List;

/**
 * ⭐⭐️⭐️️第k个排列
 * 
 * @author zhanglei211 on 2021/9/19.
 */
class Solution {
    int[] factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public String getPermutation(int n, int k) {
        List<Integer> candidates = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        for (int i = n; i >= 1; i--) {
            int r = k / factorials[i - 1];
            int y = k % factorials[i - 1];
            k = y;
            sb.append(candidates.get(r));
            candidates.remove(r);
        }
        return sb.toString();
    }
}