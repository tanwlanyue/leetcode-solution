package LC0316;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 * 去除重复字母
 * 
 * @author zhanglei211 on 2021/11/19.
 */
class Solution {

    public String removeDuplicateLetters(String s) {
        boolean[] used = new boolean[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 已经在栈中的不要插入
            if (!used[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c) {
                    // 后面还有相同的字符，可以弹出
                    Character peek = stack.peek();
                    if (count[peek - 'a'] > 0) {
                        used[peek - 'a'] = false;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                used[c - 'a'] = true;
                stack.push(c);
            }
            count[c - 'a'] -= 1;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}