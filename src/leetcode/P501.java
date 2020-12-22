package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static leetcode.Util.printArray;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author Billy
 * @date 2020/9/24 10:45 下午
 */
public class P501 {
    List<Integer> result = new ArrayList<>();
    int maxTimes = 0;
    int curTimes = 0;
    int preVal;

    /**
     * 中序遍历：二叉搜索树中序遍历为有序序列
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        //比较当前与上个值，相等则继续累加，否则重置
        curTimes = node.val == preVal ? ++curTimes : 1;
        if (curTimes == maxTimes) {
            //如果当前次数等于之前最大值，说明有多个众数，加入结果中
            result.add(node.val);
        } else if (curTimes > maxTimes) {
            //如果当前次数大于之前最大值，当前值才是众数，清空之前结果，加入当前值
            maxTimes = curTimes;
            result.clear();
            result.add(node.val);
        }
        preVal = node.val;
        inorder(node.right);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, null, 2, 2));
        TreeNode treeNode = TreeNode.createBinaryTreePreOrder(inputList);
        P501 sou = new P501();
        printArray(sou.findMode(treeNode));
    }
}
