package leetcode;

/**
 * 122. 买卖股票的最佳时机 II(无限次)
 *
 * @author Billy
 * @date 2020/4/23 12:35 上午
 */
public class P122 {
    /**
     * 贪心算法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int max = 0;
        for (int i = 0; i < size - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    /**
     * 动态规划，适用于121(买入一次)、122(无限次)、123(两次)、188(k次)、309(冷却1天)、714(手续费)
     * <p>
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(1)
     * <p>
     * base case：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity
     * <p>
     * 状态转移方程(k=+infinity，认为k=k-1)：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     * <p>
     * 我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    public static int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums={1,2,3,4,5};
//        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit_k_inf(nums));
    }
}
