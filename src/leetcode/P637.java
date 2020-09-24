package leetcode;

import java.util.*;

/**
 * 637. 二叉树的层平均值
 *
 * @author Billy
 * @date 2020/9/12 2:35 下午
 */
public class P637 {
    /**
     * BFS遍历，计算每层平均值
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int nodeNum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                nodeNum++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / nodeNum);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        System.out.println(averageOfLevels(treeNode));
    }
}
