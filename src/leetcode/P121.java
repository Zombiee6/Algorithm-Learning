package leetcode;

/**
 * 121. 买卖股票的最佳时机(买入一次)
 *
 * @author Billy
 * @date 2020/6/21 11:43 上午
 */
public class P121 {

    /**
     * 暴力法，求出所有可能，取最大值
     * 时间复杂度 : O(N^2)
     * 空间复杂度 : O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = max > profit ? max : profit;
            }
        }
        return max;
    }

    /**
     * 动态规划,记录历史最低点，计算最大收益
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
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
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
