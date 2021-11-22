package LC0316;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 * @author zhanglei211 on 2021/11/19.
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer>[] indexTable = new ArrayList[26];
        Arrays.fill(indexTable, new ArrayList<Integer>());
        for (int i = 0; i < chars.length; i++) {
            indexTable[chars[i] - 'a'].add(i);
        }
        for (int i = 0; i < chars.length; i++) {
            indexTable[chars[i] - 'a'].add(i);
        }
        return "";
    }
}