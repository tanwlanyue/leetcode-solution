package LC0836;

/**
 * 判断矩形是否重叠
 * 
 * @author zhanglei211 on 2021/11/17.
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }
}