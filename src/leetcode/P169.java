package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 *
 * @author Billy
 * @date 2020/4/21 11:45 下午
 */
public class P169 {
    /**
     * 借助Map计数
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>(size);
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 排序，然后直接返回数组中间元素
     * 时间复杂度：O(Nlog(N))
     * 空间复杂度：O(log(N))
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * <p>
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        //该题保证众数一定存在，所以省去了计数阶段。若没有该保证，输入[1,2,3]，该方法的返回不正确
        return cand_num;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
    }
}
