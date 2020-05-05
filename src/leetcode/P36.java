package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 *
 * @author Billy
 * @date 2020/5/5 3:30 下午
 */
public class P36 {
    public static boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        //检查行
        for (int i = 0; i < rows; i++) {
            set.clear();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        //检查列
        for (int i = 0; i < cols; i++) {
            set.clear();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        //检查9宫格
        for (int i = 0; i < rows; i += 3) {
            for (int j = 0; j < cols; j += 3) {
                set.clear();
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        if (set.contains(board[m][n])) {
                            return false;
                        }
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }

    /**
     * 一次迭代
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * <p>
     * 遍历数独。
     * 检查看到每个单元格值是否已经在当前的行 / 列 / 子数独中出现过：
     * 如果出现重复，返回 false。
     * 如果没有，则保留此值以进行进一步跟踪。
     * 返回 true
     * <p>
     * 子数独：box_index = (row / 3) * 3 + columns / 3
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku2(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 使用数组代替HashMap
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku3(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    //减'1'是为了将'1'-'9'映射为0-8的数组下标（'1'对应int为49）
                    int num = board[i][j] - '1';
                    int index_box = (i / 3) * 3 + j / 3;
                    if (rows[i][num] == 1) {
                        return false;
                    } else {
                        rows[i][num] = 1;
                    }
                    if (cols[j][num] == 1) {
                        return false;
                    } else {
                        cols[j][num] = 1;
                    }
                    if (boxes[index_box][num] == 1) {
                        return false;
                    } else {
                        boxes[index_box][num] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        char[][] board = {
//                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
//                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
//                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
//                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
//        };
//        char[][] board = {
//                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
//                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
//                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
//                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
//                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
//                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
//                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
//        };
//        char[][] board = {
//                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
//        };
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku2(board));
        System.out.println(isValidSudoku3(board));
    }
}
