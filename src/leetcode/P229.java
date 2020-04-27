package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 229. 求众数 II
 *
 * @author Billy
 * @date 2020/4/25 10:27 下午
 */
public class P229 {
    /**
     * 先排序，然后找出现次数大于1/3的元素
     * 时间复杂度：O(Nlog(N))
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int cand = nums[0], count = 1;
        for (int i = 1; i < size; ++i) {
            if (cand == nums[i]) {
                count++;
            } else {
                if (count > size / 3) {
                    result.add(cand);
                }
                cand = nums[i];
                count = 1;
            }
        }
        if (count > size / 3) {
            result.add(cand);
        }
        return result;
    }

    /**
     * 摩尔投票法（抵消->计数）
     * <p>
     * 如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
     * 如果至多选两个代表，那他们的票数至少要超过⌊ 1/3 ⌋的票数；每次都拿走3个不一样的数, 那么最后剩下的, 一定是A, B.
     * 如果至多选m个代表，那他们的票数至少要超过⌊ 1/(m+1) ⌋的票数。
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement2(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        // 1、如果投A（当前元素等于A），则A的票数++;
        // 2、如果投B（当前元素等于B），B的票数++；
        // 3、如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0，如果为0,则当前元素成为新的候选人；
        //    如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一。
        for (int num : nums) {
            // 如果是候选者1，票数++
            if (cand1 == num) {
                count1++;
                continue;
            }
            // 如果是候选者2，票数++
            if (cand2 == num) {
                count2++;
                continue;
            }
            // 既不是cand1也不是cand2，如果cnt1为0，新元素作为候选者1
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 既不是cand1也不是cand2，如果cnt2为0，新元素作为候选者2
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            // 如果cand1和cand2的数量都不为0，那就都-1
            count1--;
            count2--;
        }
        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
            } else if (cand2 == num) {
                // 这里一定要用else if
                // 因为可能出现[0,0,0]这种用例，导致两个cand是一样的，写两个if结果就变为[0,0]了
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
//        int[] nums = {1,1,1,3,3,2,2,2};
//        int[] nums = {1,1};
//        int[] nums = {1,2,3};
//        int[] nums = {1};
        System.out.println(majorityElement(nums));
    }
}
