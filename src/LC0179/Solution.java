package LC0179;

import java.util.Arrays;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        String[] arr = new String[length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if("0".equals(arr[0])){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        return builder.toString();
    }
}