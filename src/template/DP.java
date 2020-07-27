package template;

/**
 * @author Billy
 * @date 2020/7/21 8:04 上午
 */
public class DP {
    public int dp(int m, int n) {
        //状态定义
        int[][] dp = new int[m + 1][n + 1];

        //初始状态
        dp[0][0] = 0;
        dp[0][1] = 0;

        //DP状态推导
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
