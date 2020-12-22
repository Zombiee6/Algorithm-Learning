package leetcode;

import static leetcode.Util.printArray;

/**
 * 27. 移除元素
 *
 * @author billy
 * @date 2020/11/2 10:40 下午
 */
public class P27 {
    /**
     * 原理同P283，moveZeroes3
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i > j) {
                    nums[j] = nums[i];
                    //只关心前j位，可注释下行
//                    nums[i] = -1;
                }
                j++;
            }
        }
        return j;
    }

    /**
     * removeElement的简化版，只需要关心返回的j位，后续不修改
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 最优
     * removeElement2优化版，减少了removeElement2中不必要的复制
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 2, 3};
//        System.out.println(removeElement(nums, 3));
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement3(nums, 2));
        printArray(nums);
    }
}
