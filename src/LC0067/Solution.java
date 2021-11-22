package LC0067;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int i = aLen - 1, j = bLen - 1;
        int jin = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || jin != 0) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + jin;
            builder.insert(0, sum % 2 == 0 ? '0' : '1');
            jin = sum / 2;
            i--;
            j--;
        }
        return builder.toString();
    }
}