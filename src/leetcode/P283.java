package leetcode;

import static leetcode.Util.printArray;

/**
 * 283. 移动零
 *
 * @author billy
 * @date 2020/10/27 11:04 下午
 */
public class P283 {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (nums[j] == 0) {
                    j++;
                    if (j > nums.length - 1) {
                        return;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    /**
     * 一次遍历，类似快排思想，将非0元素放左边，0元素放右边
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        //j指针用于找中间点0
        int j = 0;
        //i指针用于找中间点右侧非0元素
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }

        }
    }

    /**
     * 最优
     * 对moveZeroes2的优化，避免了数组开头i==j时交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes3(int[] nums) {
        if (nums == null) {
            return;
        }
        //j用于记录非0元素个数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 两次遍历，将非0元素放前面，在最后补0
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes4(int[] nums) {
        if (nums == null) {
            return;
        }
        //j用于记录非0元素个数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 0, 3, 12};
        moveZeroes2(nums);
        printArray(nums);
    }
}
