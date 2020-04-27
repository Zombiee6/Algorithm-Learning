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
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // go to next level
            level++;
        }
        return levels;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 9, null, null, 20, 15, null, null, 7, null, null}));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, null, null}));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);
    }
}
