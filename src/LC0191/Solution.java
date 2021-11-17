package LC0191;

/**
 * @author zhanglei211 on 2021/11/12.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}