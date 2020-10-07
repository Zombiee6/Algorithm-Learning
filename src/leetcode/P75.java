package leetcode;

import static leetcode.Util.printArray;

/**
 * @author billy
 * @date 2020/10/7 7:29 上午
 */
public class P75 {
    /**
     * 先计算r,w,b个数，然后对数组重新赋值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    r++;
                    break;
                case 1:
                    w++;
                    break;
                case 2:
                    b++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < r) {
                nums[i] = 0;
            } else if (i < r + w) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 使用双指针，一次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }
}
