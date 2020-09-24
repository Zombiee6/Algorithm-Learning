package leetcode;

import java.util.*;

/**
 * @author Billy
 * @date 2020/9/6 10:47 上午
 */
public class P107 {
    /**
     * BFS遍历，然后在反转ArrayList
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                levelResult.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(levelResult);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * BFS遍历存入LinkList头部
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                levelResult.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(0, levelResult);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        System.out.println(levelOrderBottom(treeNode));
        System.out.println(levelOrderBottom2(treeNode));
    }
}
