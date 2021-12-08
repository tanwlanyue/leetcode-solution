package LC0004;

/**
 * 4. 寻找两个正序数组的中位数 </br>
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 97.08% 的用户 </br>
 * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 71.57% 的用户
 * 
 * @author zhanglei211 on 2021/10/21.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if ((sum & 1) == 1) {
            return findTopK(nums1, nums2, sum / 2 + 1);
        } else {
            return (findTopK(nums1, nums2, sum / 2) + findTopK(nums1, nums2, sum / 2 + 1)) / 2d;
        }

    }

    private double findTopK(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(length1, index1 + k / 2) - 1;
            int newIndex2 = Math.min(length2, index2 + k / 2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}