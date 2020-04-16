package leetcode;

import java.util.*;

/**
 * 98. 验证二叉搜索树
 *
 * @author Billy
 * @date 2020/4/13 11:04 下午
 */
public class P98 {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        Set<Integer> set = new TreeSet<>(list);
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        return list.equals(arrayList);
    }

    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    /**
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(N)
     *
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * 中序遍历，确保每一步后面的值比前一个大即为二叉树
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(1);
//        root.left = left;
        System.out.println(isValidBST(root));
        System.out.println(isValidBST2(root));
    }
}
