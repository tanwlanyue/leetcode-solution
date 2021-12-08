package LC0006;

/**
 * 6. Z 字形变换 </br>
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 81.10% 的用户 </br>
 * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 24.52% 的用户
 * 
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int mod = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i++) {
            int index = i % mod;
            if (index >= numRows) {
                index = mod - index;
            }
            rows[index].append(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : rows) {
            builder.append(row);
        }
        return builder.toString();
    }
}