package LC0139;

import java.util.HashSet;
import java.util.List;

/**
 * TODO 单词拆分
 * 
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (set.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j + 1, i + 1)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}