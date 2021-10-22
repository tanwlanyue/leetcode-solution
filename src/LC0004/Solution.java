package LC0004;

/**
 * @author zhanglei211 on 2021/10/21.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 0) {
            return (getTopK(nums1, nums2, total / 2) + getTopK(nums1, nums2, total / 2 + 1)) / 2.0;
        } else {
            return getTopK(nums1, nums2, total / 2 + 1);
        }
    }

    private double getTopK(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0, len1 = nums1.length, len2 = nums2.length;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            } else if (index2 == len2) {
                return nums1[index1 + k - 1];
            } else if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            } else {
                int newIndex1 = Math.min(index1 + k / 2, len1) - 1;
                int newIndex2 = Math.min(index2 + k / 2, len2) - 1;
                if (nums1[newIndex1] < nums2[newIndex2]) {
                    k = k - (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k = k - (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
}