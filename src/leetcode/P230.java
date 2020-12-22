package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author Billy
 * @date 2020/8/4 6:34 上午
 */
public class P230 {
    Map<Integer, Integer> cacheMap = new HashMap<>();
    int index = 1;

    public int kthSmallest(TreeNode root, int k) {
        if (cacheMap.containsKey(k)) {
            return cacheMap.get(k);
        }
        inorderTraversal(root);
        return cacheMap.get(k);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        cacheMap.put(index++, node.val);
        inorderTraversal(node.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        while (true) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
