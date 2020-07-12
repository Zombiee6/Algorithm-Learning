package ds;

/**
 * 并查集
 *
 * @author Billy
 * @date 2020/7/8 11:13 下午
 */
public class QuickUnionUF {
    private int[] roots;

    public QuickUnionUF(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    /**
     * 路径压缩
     *
     * @param i
     * @return
     */
    private int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        roots[pRoot] = qRoot;
    }
}
