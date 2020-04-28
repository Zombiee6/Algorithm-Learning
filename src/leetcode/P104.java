package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @author Billy
 * @date 2020/4/28 11:34 下午
 */
public class P104 {
    private static int MIN, MAX = 0;

    /**
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add((node.right));
                }
            }
            max++;
        }
        return max;
    }

    /**
     * DFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return MAX;
    }

    public static void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        MAX = level > MAX ? level : MAX;
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 9, null, null, 20, 15, null, null, 7, null, null}));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, null, null}));
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{0, null, null}));
        TreeNode root = TreeNode.createBinaryTreePreOrder(inputList);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
