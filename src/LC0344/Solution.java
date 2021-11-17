package LC0344;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0, j = length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}