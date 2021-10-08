package LC0047;

import java.util.*;

/**
 * 加一个set应对数字重复
 * @author zhanglei211 on 2021/10/8.
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    path.addLast(nums[i]);
                    visited[i]=true;
                    dfs(nums,visited,path,res,step+1);
                    visited[i]=false;
                    path.removeLast();
                }
            }
        }
    }
}