package leetcode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 *
 * @author chenjie5
 * @date 2020/9/14 11:24 上午
 */
public class P94 {
    /**
     * DFS递归中序遍历
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    /**
     * 显式维护递归栈
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, null, 2, 3, null));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        P94 solution = new P94();
        System.out.println(solution.inorderTraversal(treeNode));
    }
}
