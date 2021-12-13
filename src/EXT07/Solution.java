package EXT07;

/**
 * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
 *
 * 输入两行，第一行n, k，第二行为数组序列。输出最大值。 </br>
 * 输入 </br>
 * 5 5 </br>
 * 4 7 2 10 5 </br>
 * 输出 </br>
 * 4 </br>
 * 数据保证有解，即结果至少是1。
 *
 * @author zhanglei211 on 2021/12/13.
 */
public class Solution {

    public int cut(int k, int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int i = 1, j = sum / k;
        while (i < j) {
            int mid = (i + j + 1) / 2;
            int cnt = 0;
            for (int a : arr) {
                cnt += a / mid;
            }
            if (cnt >= k) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
