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
     * 摩尔投票法
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
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }
            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
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
