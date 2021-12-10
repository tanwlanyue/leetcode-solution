package LC0744;

/**
 * 744. 寻找比目标字母大的最小字母 </br>
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 </br>
 * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 74.71% 的用户
 * 
 * @author zhanglei211 on 2021/12/8.
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int i = 0, j = length - 1;
        int ret = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                ret = mid;
                j = mid - 1;
            }
        }
        return letters[ret];
    }
}