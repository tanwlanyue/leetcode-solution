package LC0020;

import java.util.ArrayDeque;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c=='['||c=='{'||c=='('){
                stack.push(c);
            }else if(c==']'){
                if (stack.isEmpty()||stack.peek()!='[') {
                    return false;
                }
                stack.pop();
            }else if(c=='}'){
                if (stack.isEmpty()||stack.peek()!='{') {
                    return false;
                }
                stack.pop();
            }else if(c==')'){
                if (stack.isEmpty()||stack.peek()!='(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}