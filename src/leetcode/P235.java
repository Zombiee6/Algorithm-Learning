package leetcode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 二叉搜索树特点：
 * 节点N左子树上的所有节点的值都小于等于节点N的值
 * 节点N右子树上的所有节点的值都大于等于节点N的值
 * 左子树和右子树也都是 BST
 * <p>
 * 最近公共祖先：
 * 就是能让节点p和节点q不能在同一颗子树上的那个节点，或者是节点p和节点q中的一个，这种情况下其中一个节点是另一个节点的父亲节点。
 *
 * @author Billy
 * @date 2020/4/18 11:40 下午
 */
public class P235 {

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

    /**
     * 利用BST特点，减少递归分支
     * 1.从根节点开始遍历树
     * 2.如果节点p和节点q都在左子树上，那么以左孩子为根节点继续1的操作
     * 3.如果节点p和节点q都在右子树上，那么以右孩子为根节点继续1的操作
     * 4.如果条件2和条件3都不成立，这就意味着我们已经找到节p和节点q的LCA了
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null && p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        if (root != null && p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }

    /**
     * 迭代法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

}
