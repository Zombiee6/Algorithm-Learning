package leetcode;

import static leetcode.Util.printArray;

/**
 * 80. 删除排序数组中的重复项 II
 *
 * @author billy
 * @date 2020/11/9 9:38 下午
 */
public class P80 {
    /**
     * 覆盖多余的重复项
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * 最简写法。基于P26的removeDuplicates3。
     * 快、慢指针，不同时交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates2(nums));
        printArray(nums);
    }
}
