package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author Billy
 * @date 2020/3/31 8:50 下午
 */
public class P1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        print(twoSum(nums, target));
    }
}
