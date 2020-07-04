package leetcode;

import static leetcode.P122.maxProfit_k_inf;

/**
 * 188. 买卖股票的最佳时机 IV(k次)
 *
 * @author Billy
 * @date 2020/6/23 10:57 下午
 */
public class P188 {
    /**
     * 动态规划，适用于121(买入一次)、122(无限次)、123(两次)、188(k次)、309(冷却1天)、714(手续费)
     * <p>
     * 时间复杂度 : O(N^2)
     * 空间复杂度 : O(N^2)
     * <p>
     * base case：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     */
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            return maxProfit_k_inf(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
