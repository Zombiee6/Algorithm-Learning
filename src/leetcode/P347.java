package leetcode;

import java.util.*;
import java.util.stream.Collectors;

import static leetcode.Util.printArray;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author Billy
 * @date 2020/8/6 11:21 下午
 */
public class P347 {

    /**
     * 借助java8的stream api
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> keyMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (keyMap.containsKey(nums[i])) {
                keyMap.put(nums[i], keyMap.get(nums[i]) + 1);
            } else {
                keyMap.put(nums[i], 1);
            }
        }

        Map<Integer, Integer> sortedMap = keyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int[] result = new int[k];
        int i = 0;
        for (Integer integer : sortedMap.keySet()) {
            result[i++] = integer;
            if (i == k) {
                break;
            }
        }
        return result;
    }

    /**
     * 最小堆
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(N)
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
        }
        // 遍历map，用小顶堆保存频率最大的k个元素
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }
        // 取出最堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.remove());
        }
        return res;
    }

    /**
     * 大顶堆
     */
    public static List<Integer> topKFrequent3(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历map，用大顶堆保存所有元素
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Integer key : map.keySet()) {
            heap.add(key);
        }
        // 取出堆顶K个元素
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.remove());
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        printArray(topKFrequent(nums, 2));
        System.out.println(topKFrequent2(nums, 2));
    }
}
