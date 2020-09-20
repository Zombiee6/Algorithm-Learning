package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author chenjie5
 * @date 2020/9/20 10:19 上午
 */
public class P78 {
    /**
     * 非递归：先加入一个空集让他成为新的子集，然后每遍历一个元素就在原来的子集的后面追加这个值
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            for (int i = 0, j = res.size(); i < j; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }
}
