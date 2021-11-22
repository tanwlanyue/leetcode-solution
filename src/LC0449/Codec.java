package LC0449;

import java.util.LinkedList;

/**
 * 二叉搜索树可以先序遍历记录  排序后得到中序遍历
 * @author zhanglei211 on 2021/11/18.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        return root.val + "!" + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split("!");
        LinkedList<Integer> queue = new LinkedList<>();
        for (String s : split) {
            if (s.equals("#")) {
                queue.add(null);
            } else {
                queue.add(Integer.valueOf(s));
            }
        }
        return deserialize(queue);
    }

    private TreeNode deserialize(LinkedList<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Integer poll = queue.poll();
        if (poll == null) {
            return null;
        }
        TreeNode root = new TreeNode(poll);
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}