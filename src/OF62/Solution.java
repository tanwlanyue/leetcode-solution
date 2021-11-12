package OF62;

/**
 * @author zhanglei211 on 2021/11/10.
 */
class Solution {
    public int lastRemaining(int n, int m) {
        // 共n个数字 经过n-1次删除 每个删除第m个数字,得到最后剩余的数字
        int p = 1;
        for (int i = 1; i < n; i++) {
            // 此时有i+1个数字
            p = (p + m) % (i + 1);
        }
        return p;
    }
}