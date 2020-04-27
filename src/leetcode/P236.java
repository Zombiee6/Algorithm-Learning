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
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * <p>
     * 两个节点p,q分为两种情况：
     * p和q在相同子树中
     * p和q在不同子树中
     * 从根节点遍历，递归向左右子树查询节点信息
     * 递归终止条件：如果当前节点为空或等于p或q，则返回当前节点
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
            //在左子树中没有找到，那一定在右子树中
            return right;
        } else if (right == null) {
            //在右子树中没有找到，那一定在左子树中
            return left;
        } else {
            //不在左子树，也不在右子树，那说明是根节点
            return root;
        }
    }
}
