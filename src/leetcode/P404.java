package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 *
 * @author Billy
 * @date 2020/9/19 7:35 下午
 */
public class P404 {
    /**
     * dfs
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode treeNode, boolean isLeft) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null && isLeft) {
            return treeNode.val;
        }
        int left = dfs(treeNode.left, true);
        int right = dfs(treeNode.right, false);
        return left + right;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        return root != null ? dfs2(root) : 0;
    }

    public int dfs2(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs2(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs2(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * bfs
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public int sumOfLeftLeaves4(TreeNode root) {
        return root == null ? 0 : sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        P404 solution = new P404();
        System.out.println(solution.sumOfLeftLeaves(treeNode));
    }
}
