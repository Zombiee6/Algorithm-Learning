package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 *
 * @author Billy
 * @date 2020/5/5 9:45 上午
 */
public class P51 {
    /**
     * 撇和捺分别有2n-1条
     * 正斜线(撇、次对角线)：row+col=常数；反斜线(捺、主对角线)：row-col=常数
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new String[n], res);
        return res;
    }

    /**
     * DFS回溯
     * 时间复杂度：O(N!).放置第 1 个皇后有 N 种可能的方法，放置两个皇后的方法不超过 N (N - 2) ，放置 3 个皇后的方法不超过 N(N - 2)(N - 4) ，以此类推.
     * 空间复杂度：O(N).需要保存对角线和列的信息
     *
     * @param r
     * @param col
     * @param slash
     * @param backlash
     * @param board
     * @param res
     */
    public static void dfs(int r, boolean[] col, boolean[] slash, boolean[] backlash, String[] board, List<List<String>> res) {
        //获得可行解法，把解法放入结果中
        if (r == board.length) {
            res.add(Arrays.asList(board.clone()));
            return;
        }
        //循环列，试图在每个列中放置皇后
        for (int c = 0; c < board.length; c++) {
            //将正反斜线映射为数组下标
            int slashId = r + c, backslashId = r - c + board.length - 1;
            //如果（r，c）不在攻击范围内，则放置皇后
            if (!col[c] && !slash[slashId] && !backlash[backslashId]) {
                char[] row = new char[board.length];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board[r] = new String(row);
                col[c] = true;
                slash[slashId] = true;
                backlash[backslashId] = true;
                //考虑下一行皇后放置位置
                dfs(r + 1, col, slash, backlash, board, res);
                //还原棋盘
                col[c] = false;
                slash[slashId] = false;
                backlash[backslashId] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
