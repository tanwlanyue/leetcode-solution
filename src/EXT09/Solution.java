package EXT09;

/**
 * 类似LC415
 * 
 * @author zhanglei211 on 2021/12/13.
 */
public class Solution {

    public char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    private int getInt(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a' + 10;
        }
    }
}
