package leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author Billy
 * @date 2020/9/21 10:44 下午
 */
public class P538 {
    int sum = 0;

    /**
     * 反序中序遍历
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
