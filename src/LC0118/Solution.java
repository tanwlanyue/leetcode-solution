package LC0118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei211 on 2021/11/22.
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(1);
        lists.add(firstLevel);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(i);
                } else {
                    List<Integer> preLevel = lists.get(i - 1);
                    list.add(preLevel.get(j - 1) + preLevel.get(j));
                }
            }
            lists.add(list);
        }
        return lists;
    }
}