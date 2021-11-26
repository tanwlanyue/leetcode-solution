package LC0455;

import java.util.Arrays;

/**
 * TODO
 * @author zhanglei211 on 2021/11/24.
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = count; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}