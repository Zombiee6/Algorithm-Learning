package leetcode;

import java.util.LinkedList;

/**
 * @author Billy
 * @date 2020/4/13 11:03 下午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createBinaryTreePreOrder(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTreePreOrder(inputList);
            node.right = createBinaryTreePreOrder(inputList);
        }
        return node;
    }
}
