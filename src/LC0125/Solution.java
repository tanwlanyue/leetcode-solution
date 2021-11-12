package LC0125;

/**
 * @author zhanglei211 on 2021/11/11.
 */
class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        int i = 0, j = length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            char a = s.charAt(i);
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            char b = s.charAt(j);
            if (Character.toLowerCase(a)!=Character.toLowerCase(b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}