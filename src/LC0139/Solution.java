package LC0139;

import java.util.List;

/**
 * TODO
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    boolean flag = false;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        this.dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            String substring = s.substring(i);
            for (String word : wordDict) {
                if (substring.startsWith(word)) {

                }
            }
        }

        return flag;
    }
}