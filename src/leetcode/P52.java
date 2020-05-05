package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 52. N皇后 II(返回解法数量)
 *
 * @author Billy
 * @date 2020/5/5 1:34 下午
 */
public class P52 {
    public static int totalNQueens(int n) {
        return P51.solveNQueens(n).size();
    }

    /**
     * 基于P51 DFS解法改造
     * 时间复杂度：O(N!)
     * 空间复杂度：O(N)
     *
     * @param n
     * @return
     */
    public static int totalNQueens2(int n) {
        return dfs(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], n, 0);
    }

    public static int dfs(int r, boolean[] col, boolean[] slash, boolean[] backslash, int n, int count) {
        if (r == n) {
            count++;
            return count;
        }
        for (int c = 0; c < n; c++) {
            int slashId = r + c, backslashId = r - c + n - 1;
            if (!col[c] && !slash[slashId] && !backslash[backslashId]) {
                col[c] = true;
                slash[slashId] = true;
                backslash[backslashId] = true;
                count = dfs(r + 1, col, slash, backslash, n, count);
                col[c] = false;
                slash[slashId] = false;
                backslash[backslashId] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens2(4));
    }
}
