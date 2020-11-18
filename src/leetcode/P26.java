package leetcode;

import static leetcode.Util.printArray;

/**
 * 26. 删除排序数组中的重复项
 *
 * @author billy
 * @date 2020/11/3 10:39 下午
 */
public class P26 {
    /**
     * 原理同P27 removeElement，区别在于val动态更新
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                val = nums[i];
                if (i > j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        return j;
    }

    /**最优
     * 快、慢指针，不同时交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 最简写法，但是交换次数比removeDuplicates2多
     * 快、慢指针，不同时交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeDuplicates3(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if(i < 1 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 2};
//        int[] nums = new int[]{1, 2, 2};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates3(nums));
        printArray(nums);
    }
}
