package leetcode;

import java.util.HashMap;

/**
 * 70. 爬楼梯
 *
 * @author Billy
 * @date 2020/6/10 10:35 下午
 */
public class P70 {
    private static HashMap<Integer, Integer> resMap = new HashMap();

    /**
     * 动态规划（递推）
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(N)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * 递归
     * 时间复杂度 : O(2^N)
     * 空间复杂度 : O(N)
     *
     * @param n
     * @return
     */
    public static int recursion(int n) {
        if (n <= 2) {
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * 递归，缓存结果
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(N)
     *
     * @param n
     * @return
     */
    public static int recursion2(int n) {
        if (n <= 2) {
            return n;
        }
        if (resMap.containsKey(n)) {
            return resMap.get(n);
        }
        int ret = recursion2(n - 1) + recursion2(n - 2);
        resMap.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(recursion(6));
        System.out.println(recursion2(6));
    }
}
