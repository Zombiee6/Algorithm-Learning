package leetcode;

/**
 * @author billy
 */
public class StockProblem {
    /**
     * https://leetcode-cn.com/circle/article/qiAgHn/
     * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
     * 动态规划，适用于121(买入一次)、122(无限次)、309(冷却1天)、714(手续费)、123(两次)、188(k次)
     * <p>
     * dp[-1][k][0]=dp[i][0][0]=0
     * dp[-1][k][1]=dp[i][0][1]=-infinity
     * <p>
     * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * <p>
     * return dp[n][k][0]
     */

    /**
     * k无限大，冷冻期为 1 天（卖出后无法在第二天买入）。
     * <p>
     * dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i])
     * dp[i][1]=max(dp[i-1][1],dp[i-1-cooldown][0]-prices[i])
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k_inf_cool(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 基于maxProfit_k_inf优化空间
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k_inf_opt(int[] prices) {
        int n = prices.length;
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i < n; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, profit0 - prices[i]);
        }
        return profit0;
    }

    /**
     * k无限大，即k=k-1，k不再影响状态转移方程
     * dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i])
     * dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i])
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 只要第二天价格比当天高就交易
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k_inf_greedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * 基于maxProfit_k1优化空间
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k_1_opt(int[] prices) {
        int n = prices.length;
        int profit0 = 0;
        int profit1 = -prices[0];
        //i从1开始
        for (int i = 1; i < n; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }

    /**
     * k=1
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     */
    public int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        //   dp[0][0]
        // = max(dp[-1][0], dp[-1][1] + prices[i])
        // = max(0, -infinity + prices[i]) = 0
        dp[0][0] = 0;

        //   dp[0][1]
        // = max(dp[-1][1], dp[-1][0] - prices[i])
        // = max(-infinity, 0 - prices[i])
        // = -prices[i]
        dp[0][1] = -prices[0];

        //i从1开始
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
            //dp[i-1][k-1][0]=dp[i-1][0][0]=0
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 找差价最大
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     */
    public int maxProfit_k1_greedy(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{1, 2, 3, 0, 2};
        //k=1
//        System.out.println(new StockProblem().maxProfit_k1_greedy(prices));
//        System.out.println(new StockProblem().maxProfit_k_1(prices));
//        System.out.println(new StockProblem().maxProfit_k_1_opt(prices));
        //k=inf
//        System.out.println(new StockProblem().maxProfit_k_inf_greedy(prices));
//        System.out.println(new StockProblem().maxProfit_k_inf(prices));
//        System.out.println(new StockProblem().maxProfit_k_inf_opt(prices));
        //k=inf & cool down
        System.out.println(new StockProblem().maxProfit_k_inf_cool(prices));

    }
}
