package LC0056;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/10/28.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int end = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] peek = intervals[end];
            if (interval[0] > peek[1]) {
                intervals[++end] = interval;
            } else {
                peek[1] = Math.max(peek[1], interval[1]);
            }
        }
        return Arrays.copyOf(intervals, end + 1);
    }
}