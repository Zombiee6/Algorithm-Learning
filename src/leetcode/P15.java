package leetcode;

import java.util.*;

/**
 * 15. 三数之和
 *
 * @author Billy
 * @date 2020/4/12 4:52 下午
 */
public class P15 {
    /**
     * 暴力法，时间复杂度：O(N^3)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        //用于去重
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //用于去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                //用于去重
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    //用于去重
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 暴力法，借助LinkedHashSet去重，时间复杂度：O(N^3)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        //借助LinkedHashSet去重，LinkedHashSet去重后顺序一致，HashSet不保证顺序
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 参考TwoSum解法，利用Set保存两数和。
     * 时间复杂度：O(N^2)
     * 空间杂度：O(N)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.contains(-(nums[i] + nums[j]))) {
                    result.add(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
            set.add(nums[i]);
        }
        return new ArrayList<>(result);
    }

    /**
     * 夹逼法
     * 时间复杂度：O(N^2)
     * 空间杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum4(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(value);
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 夹逼法快速版
     * 时间复杂度：O(N^2)
     * 空间杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum5(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }
            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return result;
    }

    /**
     * 夹逼法
     * 时间复杂度：O(N^2)
     * 空间杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum6(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                if (nums[head] + nums[tail] == target) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                    head++;
                    tail--;
                } else if (nums[head] + nums[tail] > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        final int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        final int[] nums = new int[]{-2, 0, 1, 1, 2};
//        final int[] nums = new int[]{0, 0, 0, 0};

        System.out.println(threeSum2(nums.clone()));
        System.out.println(threeSum3(nums.clone()));
        System.out.println(threeSum4(nums.clone()));
        System.out.println(threeSum5(nums.clone()));
        System.out.println(threeSum6(nums.clone()));
    }
}
