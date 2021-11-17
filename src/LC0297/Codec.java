package LC0297;

import java.util.LinkedList;

/**
 * @author zhanglei211 on 2021/11/12.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "!#";
        }
        return root.val + "#" + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split("#");
        LinkedList<Integer> queue = new LinkedList<>();
        for (String s : split) {
            if (s.equals("!")) {
                queue.add(null);
            } else {
                queue.add(Integer.valueOf(s));
            }
        }
        return deserialize(queue);
    }

    private TreeNode deserialize(LinkedList<Integer> queue) {
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