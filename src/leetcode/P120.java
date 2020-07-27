package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static leetcode.Util.printArray;

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

    /**
     * 无需额外空间，但改变了传入参数
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = triangle.get(i).size() - 1; j >= 0; --j) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal3(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
//                System.out.println("i:" + i + ",j:" + j + ",row[j]:" + rows.get(j));
//                printArray(dp);
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
//                printArray(dp);
            }
        }
        return dp[0];
    }

    /**
     * 递归（超时）
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal4(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        return dfs(triangle, 0, 0, "", 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j, String path, int sum) {
        // terminator
//        if (i == triangle.size()) {
//            System.out.println(path + " with sum:" + sum);
//            return 0;
//        }
        if (i == triangle.size() - 1) {
            path += triangle.get(i).get(j);
            sum += triangle.get(i).get(j);
            System.out.println(path + " with sum:" + sum);
            return sum;
        }

        // process
        path += triangle.get(i).get(j) + " ->";
        sum += triangle.get(i).get(j);

        // drill down
        int left = dfs(triangle, i + 1, j, path, sum);
        int right = dfs(triangle, i + 1, j + 1, path, sum);

        // clear stats
        // NOTE: no need to clear path

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal2(triangle));
    }
}
