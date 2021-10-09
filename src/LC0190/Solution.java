package LC0190;

/**
 * @author zhanglei211 on 2021/10/9.
 */
public class Solution {

    public int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i++) {
            m = m << 1;
            if ((n & 1) == 1) {
                m++;
            }
            n = n >> 1;
        }
        return m;
    }
}
