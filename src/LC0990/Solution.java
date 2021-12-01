package LC0990;

import java.util.ArrayList;

/**
 * @author zhanglei211 on 2021/11/30.
 */
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        ArrayList<String> noEqualsList = new ArrayList<>();
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            boolean equals = equation.charAt(1) == '=';
            int b = equation.charAt(3) - 'a';
            if (equals) {
                connect(parent, a, b);
            } else {
                noEqualsList.add(equation);
            }
        }
        for (String equation : noEqualsList) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (findParent(parent, a) == findParent(parent, b)) {
                return false;
            }
        }
        return true;
    }

    private void connect(int[] parent, int a, int b) {
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int bParent = findParent(parent, b);
        int aParent = findParent(parent, a);
        parent[bParent] = aParent;
    }

    private int findParent(int[] parent, int a) {
        while (parent[a] != a) {
            a = parent[a];
        }
        return parent[a];
    }
}