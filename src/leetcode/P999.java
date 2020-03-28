package leetcode;

import java.util.Arrays;

/**
 * Available Captures for Rook
 *
 * @author Billy
 * @date 2020/3/28 1:55 下午
 */
public class P999 {
    public int numRookCaptures(char[][] board) {
        int num = 0;
        int rookX = -1;
        int rookY = -1;
        //find Rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    //这样无法跳出外层循环
                    break;
                }
            }
        }
        //up
        for (int i = rookX - 1; i > 0; i--) {
            if (board[i][rookY] == 'B') {
                break;
            }
            if (board[i][rookY] == 'p') {
                num++;
                break;
            }
        }
        //down
        for (int i = rookX + 1; i < 8; i++) {
            if (board[i][rookY] == 'B') {
                break;
            }
            if (board[i][rookY] == 'p') {
                num++;
                break;
            }
        }
        //left
        for (int j = rookY - 1; j > 0; j--) {
            if (board[rookX][j] == 'B') {
                break;
            }
            if (board[rookX][j] == 'p') {
                num++;
                break;
            }
        }
        //right
        for (int j = rookX + 1; j < 8; j++) {
            if (board[rookX][j] == 'B') {
                break;
            }
            if (board[rookX][j] == 'p') {
                num++;
                break;
            }
        }
        return num;
    }

    /**
     * 方向数组
     *
     * @param board
     * @return
     */
    public int numRookCaptures2(char[][] board) {
        int num = 0;
        int rookX = -1;
        int rookY = -1;
        //find Rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    break;
                }
            }
        }
        //定义4个方向,按右、下、左、上依次遍历
//        int[] dx = {0, 1, 0, -1};
//        int[] dy = {1, 0, -1, 0};
        int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < 4; ++i) {
            for (int step = 0; ; step++) {
//                int tx = rookX + step * dx[i];
//                int ty = rookY + step * dy[i];
                int tx = rookX + step * directions[i][0];
                int ty = rookY + step * directions[i][1];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    num++;
                    break;
                }
            }
        }
        return num;
    }

    int cap(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
            if (b[x][y] == 'p') {
                return 1;
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

    /**
     * 找到Rook后直接return
     *
     * @param b
     * @return
     */
    public int numRookCaptures3(char[][] b) {
        for (int i = 0; i < b.length; ++i) {
            for (int j = 0; j < b[i].length; ++j) {
                if (b[i][j] == 'R') {
                    return cap(b, i, j, 0, 1) + cap(b, i, j, 0, -1) + cap(b, i, j, 1, 0) + cap(b, i, j, -1, 0);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(new P999().numRookCaptures(board));
        System.out.println(new P999().numRookCaptures2(board));
        System.out.println(new P999().numRookCaptures3(board));
    }
}
