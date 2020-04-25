package leetcode;

/**
 * 122. 买卖股票的最佳时机 II
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

    public static void main(String[] args) {
//        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums={1,2,3,4,5};
        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
    }
}
