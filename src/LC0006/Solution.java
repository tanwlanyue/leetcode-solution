package LC0006;

import java.util.ArrayList;

/**
 * @author zhanglei211 on 2021/11/16.
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[] arr = s.toCharArray();
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        return convert(arr, list, numRows);
    }

    private String convert(char[] arr, ArrayList<StringBuilder> list, int numRows) {
        int mod = numRows * 2 - 2;
        for (int i = 0; i < arr.length; i++) {
            int index = i % mod;
            if (index > numRows - 1) {
                index =mod - index;
            }
            list.get(index).append(arr[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder.toString());
        }
        return builder.toString();
    }
}