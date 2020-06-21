package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author Billy
 * @date 2020/6/11 10:10 下午
 */
public class P120 {
    /**
     * 动态规划
     * 时间复杂度 : O(N^2)
     * 空间复杂度 : O(N)
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] mini = triangle.get(triangle.size() - 1).stream().mapToInt(Integer::valueOf).toArray();
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
            }
        }
        return mini[0];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3, 4}));
        triangle.add(Arrays.asList(new Integer[]{6, 5, 7}));
        triangle.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));

        System.out.println(minimumTotal(triangle));
    }
}
