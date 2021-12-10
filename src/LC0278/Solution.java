package LC0278;

/**
 * 278. 第一个错误的版本 </br>
 * 执行用时： 11 ms , 在所有 Java 提交中击败了 99.97% 的用户 </br>
 * 内存消耗： 34.7 MB , 在所有 Java 提交中击败了 98.76% 的用户
 * 
 * @author zhanglei211 on 2021/12/8.
 */
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = (i + j) / 2;
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}