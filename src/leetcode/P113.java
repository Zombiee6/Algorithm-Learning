package leetcode;

import java.util.*;

/**
 * 113. 路径总和 II
 *
 * @author billy
 * @date 2020/9/26 1:32 下午
 */
public class P113 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 递归
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.offerLast(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        path.pollLast();
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(5, 4, 11, 7, null, null, 2, null, null, null, 8, 13, null, null, 4, 5, null, null, 1));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        P113 solution = new P113();
        System.out.println(solution.pathSum(treeNode, 22));
    }
}
