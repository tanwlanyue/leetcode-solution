package LC1339;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/11/29.
 */
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        int total = dfs(root);
        int target = total / 2;
        Collections.sort(list);
        long max = 0;
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            Integer migVal = list.get(mid);
            if (migVal >= target) {
                max = Math.max(max, (long) migVal * (total - migVal));
                j = mid - 1;
            } else {
                max = Math.max(max, (long) migVal * (total - migVal));
                i = mid + 1;
            }
        }
        max = max % 1000000007;
        return (int) max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        list.add(sum);
        return sum;
    }
}