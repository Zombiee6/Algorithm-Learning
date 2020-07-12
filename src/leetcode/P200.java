package leetcode;

import ds.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 *
 * @author Billy
 * @date 2020/7/8 11:23 下午
 */
public class P200 {
    /**
     * DFS
     * 时间复杂度：O(N*M)
     * 空间复杂度：O(N*M)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到NM
     * 该方法改变了传入的grid
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void DFSMarking(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        //四个方向不能省略
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    /**
     * BFS
     * 时间复杂度：O(N*M)
     * 空间复杂度：O(min(N,M))，最坏情况下，整个网格均为陆地，队列的大小可以达到 min(N,M)
     *
     * @param grid
     * @return
     */
    public static int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++count;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 并查集
     *
     * @param grid
     * @return
     */
    public static int numIslandsUF(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
//                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
//                        uf.union(r * nc + c, (r - 1) * nc + c);
//                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
//                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
//                        uf.union(r * nc + c, r * nc + c - 1);
//                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslandsBFS(grid2));
        char[][] grid3 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslandsUF(grid3));
    }
}
