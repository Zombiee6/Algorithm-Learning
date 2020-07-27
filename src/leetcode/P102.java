package leetcode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * @author Billy
 * @date 2020/4/27 10:47 下午
 */
public class P102 {
    /**
     * 迭代
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }

    /**
     * 递归：前序深度优先
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }

    public static void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7, null, null));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, null, null}));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        List<List<Integer>> lists = levelOrder2(treeNode);
        System.out.println(lists);
    }
}
