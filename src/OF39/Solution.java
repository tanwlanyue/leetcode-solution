package OF39;

/**
 * @author zhanglei211 on 2021/11/12.
 */
class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (--count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }
}