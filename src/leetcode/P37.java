package leetcode;

/**
 * 37. 解数独
 *
 * @author Billy
 * @date 2020/5/6 11:13 下午
 */
public class P37 {
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    /**
     * DFS遍历
     * 时间复杂度：(9!)^9，每行有9! 种可能，一共有9行。
     * 空间复杂度：O(81)，固定大小存储数独。
     * <p>
     * 逐行，从左到右，在每一个位置上试探1-9，成功就进入下一个位置，失败就取消本次选择，做下一个选择
     *
     * @param board
     * @return
     */
    public static boolean solve(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                //回溯还原
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //检查所在列
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            //检查所在行
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            //检查九宫格
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] != '.'
                    && board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
