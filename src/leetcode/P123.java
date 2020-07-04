package leetcode;

/**
 * 123. 买卖股票的最佳时机 III(两次)
 *
 * @author Billy
 * @date 2020/6/28 10:44 下午
 */
public class P123 {
    /**
     * 动态规划，适用于121(买入一次)、122(无限次)、123(两次)、188(k次)、309(冷却1天)、714(手续费)
     * <p>
     * 时间复杂度 : O(Nk)
     * 空间复杂度 : O(1)
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{}));
    }
}
