package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * @author Billy
 * @date 2020/4/29 10:46 下午
 */
public class P111 {
    /**
     * BFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    /**
     * DFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(log(N))~O(N)（树完全平衡～树完全不平衡）
     *
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth2(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth2(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth3(root.left);
        int m2 = minDepth3(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) {
            return m1 + m2 + 1;
        }
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1, m2) + 1;
    }

    public static void main(String[] args) {
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 9, null, null, 20, 15, null, null, 7, null, null}));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, null, null}));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{0, null, null}));
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, null, null, null}));
        TreeNode root = TreeNode.createBinaryTreePreOrder(inputList);
        System.out.println(minDepth(root));
        System.out.println(minDepth2(root));
        System.out.println(minDepth3(root));
    }
}
