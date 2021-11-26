package LC0287;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i){
                int num=nums[i];
                if(nums[num]==num){
                    return num;
                }
                swap(nums,i,num);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}