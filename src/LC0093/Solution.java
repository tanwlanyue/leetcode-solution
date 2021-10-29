package LC0093;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution {
    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        LinkedList<String> path = new LinkedList<>();
        dfs(s, 0, path);
        return res;
    }

    private void dfs(String s, int start, LinkedList<String> path) {
        if (path.size() == 4) {
            if (start == s.length()) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    builder.append(path.get(i));
                    if (i != path.size() - 1) {
                        builder.append('.');
                    }
                }
                res.add(builder.toString());
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (valid(s, start, i)) {
                    String substring = s.substring(start, start + i);
                    System.out.println(substring);
                    path.add(substring);
                    dfs(s, start + i, path);
                    path.removeLast();
                }
            }
        }
    }

    boolean valid(String s, int start, int size) {
        if (start + size > s.length()) {
            return false;
        }
        if (size == 1) {
            int num1 = s.charAt(start) - '0';
            return num1 >= 0 && num1 <= 9;
        }
        if (size == 2) {
            int num1 = s.charAt(start) - '0';
            int num2 = s.charAt(start + 1) - '0';
            return num1 >= 1 && num1 <= 9 && num2 >= 0 && num2 <= 9;
        }
        if (size == 3) {
            int num1 = s.charAt(start) - '0';
            int num2 = s.charAt(start + 1) - '0';
            int num3 = s.charAt(start + 2) - '0';
            if (num1 == 2) {
                if (num2 == 5) {
                    return num3 >= 0 && num3 <= 5;
                } else if (num2 >= 0 && num2 <= 4) {
                    return num3 >= 0 && num3 <= 9;
                }
            } else if (num1 == 1) {
                return num2 >= 0 && num2 <= 9 && num3 >= 0 && num3 <= 9;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("000256");
    }
}