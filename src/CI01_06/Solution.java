package CI01_06;

/**
 * @author zhanglei211 on 2021/10/25.
 */
class Solution {
    public String compressString(String S) {
        int length = S.length();
        if(length==0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char pre = S.charAt(0);
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == pre) {
                count++;
            } else {
                builder.append(pre);
                builder.append(count);
                count = 1;
                pre = S.charAt(i);
            }
            if (i == length - 1) {
                builder.append(pre);
                builder.append(count);
            }
        }
        String s = builder.toString();
        return s.length() < length ? s : S;
    }
}