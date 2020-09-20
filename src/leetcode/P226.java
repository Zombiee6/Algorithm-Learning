package leetcode;

/**
 * 226. 翻转二叉树
 *
 * @author chenjie5
 * @date 2020/9/17 10:43 下午
 */
public class P226 {
    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
