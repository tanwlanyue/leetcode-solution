package LC0095;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.util.Pair;

/**
 * 95. 不同的二叉搜索树 II </br>
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.78% 的用户 </br>
 * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 96.26% 的用户
 * 
 * @author zhanglei211 on 2021/9/11.
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {
        HashMap<Pair<Integer, Integer>, List<TreeNode>> map = new HashMap<>();
        return generateTrees(map, 1, n);
    }

    private List<TreeNode> generateTrees(HashMap<Pair<Integer, Integer>, List<TreeNode>> map, int min, int max) {
        if (min > max) {
            return null;
        }
        Pair<Integer, Integer> pair = new Pair<>(min, max);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        ArrayList<TreeNode> lists = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftNodes = generateTrees(map, min, i - 1);
            List<TreeNode> rightNodes = generateTrees(map, i + 1, max);
            if (leftNodes == null && rightNodes == null) {
                TreeNode root = new TreeNode(i);
                lists.add(root);
            } else if (leftNodes == null) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    lists.add(root);
                }
            } else if (rightNodes == null) {
                for (TreeNode leftNode : leftNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    lists.add(root);
                }
            } else {
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        lists.add(root);
                    }
                }
            }
        }
        map.put(pair, lists);
        return lists;
    }
}