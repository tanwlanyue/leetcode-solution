package EXT02;

/**
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 * 
 * @author zhanglei211 on 2021/11/17.
 */
public class Solution {

    public int count(int size, int n) {
        // 设dp[i][j]为从0点出发走i步到j点的方案数
        int[][] dp = new int[n + 1][size];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + size) % size] + dp[i - 1][(j + 1) % size];
            }
        }
        return dp[n][0];
    }
}
