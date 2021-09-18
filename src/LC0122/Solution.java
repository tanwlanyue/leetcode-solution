package LC0122;

/**
 * @author zhanglei211 on 2021/9/18.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            int minus = prices[i] - prices[i - 1];
            if (minus > 0) {
                count += minus;
            }
        }
        return count;
    }
}