package leetcode;

/**
 * 面试题04. 二维数组中的查找
 *
 * @author Billy
 * @date 2020/3/29 3:05 下午
 */
public class I04 {
    /**
     * 暴力法遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] > target || matrix[i][m - 1] < target) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
     * 当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
     * 当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
     * 当 matrix[i][j] == target 时： 返回 true。
     * 若行索引或列索引越界，则代表矩阵中无目标值，返回 false。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
//        int[][] m = {{1}, {4}, {7}, {11}, {15}};
//        int[][] m = {{}};
        int target = 5;
        System.out.println(new I04().findNumberIn2DArray(m, target));
        System.out.println(new I04().findNumberIn2DArray2(m, target));
    }
}
