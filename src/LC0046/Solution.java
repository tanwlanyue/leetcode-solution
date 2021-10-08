package LC0046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList#remove方法调的unlinkFirst
 * @author zhanglei211 on 2021/10/8.
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] visited = new boolean[length];
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums,visited,path,res,0);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> path, ArrayList<List<Integer>> res, int step) {
        if(step==nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                path.addLast(nums[i]);
                visited[i]=true;
                dfs(nums,visited,path,res,step+1);
                visited[i]=false;
                path.removeLast();
            }
        }
    }
}