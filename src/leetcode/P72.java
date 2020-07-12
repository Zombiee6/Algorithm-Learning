package leetcode;

/**
 * 72. 编辑距离
 *
 * @author Billy
 * @date 2020/7/5 9:58 上午
 */
public class P72 {
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //第一行，word1为空变成word2（插入）
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //第一列，word2为空（删除）
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        //对word1，插入：dp[i][j - 1]，删除：dp[i - 1][j]，替换：dp[i - 1][j - 1]
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
