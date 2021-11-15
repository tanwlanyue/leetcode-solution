package LC0168;

/**
 * @author zhanglei211 on 2021/11/15.
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            int a = (columnNumber - 1) % 26 + 1;
            char c = (char) ('A' + a - 1);
            columnNumber = columnNumber / 26;
            builder.insert(0, c);
        }
        return builder.toString();
    }
}