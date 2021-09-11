package LC0094;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * ⭐️⭐️⭐️ 中序遍历 左根右
 * 
 * @author zhanglei211 on 2021/9/11.
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        inorder(root,res);
//        return res;
//    }
//
//    private void inorder(TreeNode root, ArrayList<Integer> res) {
//        if(root==null){
//            return;
//        }
//        inorder(root.left,res);
//        res.add(root.val);
//        inorder(root.right,res);
//    }
}