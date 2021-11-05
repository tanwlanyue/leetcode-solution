package LC0094;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ⭐️⭐️⭐️ 中序遍历 左根右
 * 
 * @author zhanglei211 on 2021/9/11.
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    // public List<Integer> inorderTraversal(TreeNode root) {
    // ArrayList<Integer> res = new ArrayList<>();
    // inorder(root,res);
    // return res;
    // }
    //
    // private void inorder(TreeNode root, ArrayList<Integer> res) {
    // if(root==null){
    // return;
    // }
    // inorder(root.left,res);
    // res.add(root.val);
    // inorder(root.right,res);
    // }
}