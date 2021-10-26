package LC0140;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/26.
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String> path = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();
        dfs(s, wordDict, 0, path, res);
        return res;
    }

    private void dfs(String s, List<String> wordDict, int i, LinkedList<String> path, ArrayList<String> res) {
        if (i == s.length()) {
            String join = String.join(" ", path);
            res.add(join);
        } else {
            for (String word : wordDict) {
                int sIndex = i, wIndex = 0;
                boolean flag = true;
                while (sIndex < s.length() && wIndex < word.length()) {
                    if (s.charAt(sIndex++) != word.charAt(wIndex++)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && wIndex == word.length()) {
                    path.add(word);
                    dfs(s, wordDict, sIndex, path, res);
                    path.removeLast();
                }
            }
        }
    }
}