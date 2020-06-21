package leetcode;

/**
 * 152. 乘积最大子数组
 *
 * @author Billy
 * @date 2020/6/21 10:21 上午
 */
public class P152 {
    /**
     * 记录正的最大值和最小值（可以为负）
     * 时间复杂度 : O(N)
     * 空间复杂度 : O(1)
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tmpMax = curMax * num, tmpMin = curMin * num;
            curMax = Math.max(num, Math.max(tmpMax, tmpMin));
            curMin = Math.min(num, Math.min(tmpMax, tmpMin));
            res = Math.max(curMax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-1, -2, -9, -6};
        System.out.println(maxProduct(nums));
    }
}
