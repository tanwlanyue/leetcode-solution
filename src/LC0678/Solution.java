package LC0678;

/**
 * TODO
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    public boolean checkValidString(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        return dfs(s, 0, 0, 0);
    }

    private boolean dfs(String s, int start, int leftCount, int rightCount) {
        if (leftCount < rightCount) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = start; i < chars.length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                rightCount++;
                if (leftCount < rightCount) {
                    return false;
                }
            } else if (c == '*') {
                return dfs(s, i + 1, leftCount, rightCount) || dfs(s, i + 1, leftCount + 1, rightCount)
                        || dfs(s, i + 1, leftCount, rightCount + 1);
            }
        }
        return leftCount == rightCount;
    }
}