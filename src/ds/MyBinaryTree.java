package ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 * @author Billy
 * @date 2020/2/25 10:28 下午
 */
public class MyBinaryTree {
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     * @return node
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ",");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + ",");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + ",");
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param root
     */
    public static void preOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点到左孩子点并入栈
            while (treeNode != null) {
                System.out.print(treeNode.data + ",");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历（广度优先）
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node+",");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        /**
         *                  3
         *          2              8
         *     9         10    null 4
         * null null null null
         */
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("treeNode:" + treeNode.data);
        System.out.println("前序遍历:");
        preOrderTraversal(treeNode);
        System.out.println("\n中序遍历:");
        inOrderTraversal(treeNode);
        System.out.println("\n后序遍历:");
        postOrderTraversal(treeNode);
        System.out.println("\n非递归前序遍历:");
        preOrderTraversalWithStack(treeNode);
        System.out.println("\n广度优先遍历：");
        levelOrderTraversal(treeNode);
    }
}
