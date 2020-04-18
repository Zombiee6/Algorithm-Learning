package leetcode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author Billy
 * @date 2020/4/19 12:10 上午
 */
public class P236 {
    /**
     * 适用于二叉树
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
