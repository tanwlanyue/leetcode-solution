package LC0315;

import java.util.*;

/**
 * TODO 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 * x&(-x)：保留二进制下最后出现的1的位置，其余位置置0（即一个数中最大的2的n次幂的因数 </br>
 * x&(x-1)：消除二进制下最后出现1的位置，其余保持不变
 * 
 * @author zhanglei211 on 2021/11/30.
 */
class Solution {
    private int[] c;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int[] a = discretization(nums);
        c = new int[nums.length + 1];
        Arrays.fill(c, 0);

        for (int i = nums.length - 1; i >= 0; --i) {
            int id = Arrays.binarySearch(a, nums[i]) + 1;
            // 区间查询 query(i)
            resultList.add(query(id - 1));
            // 单点更新 update(i, v)
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    /**
     * 单点更新，从子节点更新到所有父节点(祖父节点等一直往上到上限c.size())
     * 
     * @param pos
     */
    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }

    /**
     * 得到所有不同的数字 升序排列
     * 
     * @param nums
     * @return
     */
    private int[] discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] a = new int[set.size()];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
        return a;
    }
}