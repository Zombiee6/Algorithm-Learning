package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 *
 * @author Billy
 * @date 2020/4/21 11:45 下午
 */
public class P169 {
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer value = map.get(n);
            if (value != null) {
                map.put(n, value + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
