package LC1095;

/**
 * TODO
 *
 * @author zhanglei211 on 2021/12/2.
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i = 0, j = mountainArr.length() - 1;
        i++;
        j--;
        int index=-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int midVal = mountainArr.get(mid);
            int midLeftVal = mountainArr.get(mid - 1);
            int midRightVal = mountainArr.get(mid + 1);
            if(midVal==target){
                if (midVal > midLeftVal && midVal > midRightVal) {
                    return mid;
                } else if (mid > midLeftVal && midRightVal > midVal) {
                    return mid;
                } else {
                    index=mid;
                    j=mid-1;
                }
            }else if(midVal>target){
                if (midVal > midLeftVal && midVal > midRightVal) {
                    j--;
                } else if (mid > midLeftVal && midRightVal > midVal) {
                    return mid;
                } else {
                    index=mid;
                    j=mid-1;
                }



            }





        }
        return index;
    }
}