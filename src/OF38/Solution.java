package OF38;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author zhanglei211 on 2021/11/18.
 */
class Solution {
    ArrayList<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        dfs(arr, 0);
        return list.toArray(new String[] {});
    }

    private void dfs(char[] arr, int start) {
        if (start == arr.length) {
            list.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (set.add(arr[i])) {
                swap(arr, start, i);
                dfs(arr, start + 1);
                swap(arr, start, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}