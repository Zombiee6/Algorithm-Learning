package leetcode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

import static leetcode.Util.printArray;

/**
 * 239. 滑动窗口最大值
 *
 * @author Billy
 * @date 2020/4/7 10:23 下午
 */
public class P239 {

    /**
     * 暴力法：一共有N-k+1个滑动窗口，每个窗口k个元素，遍历每个滑动窗口找窗口内最大值。
     * 时间复杂度：O(Nk)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 利用最大堆
     * 时间复杂度：O(Nk)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i - k + 1 > 0) {
                //remove(object)时间复杂度O(k)，remove()时间复杂度为O(logk)
                maxHeap.remove(nums[i - k]);
            }
            maxHeap.offer(nums[i]);
            if (i - k + 1 >= 0) {
                output[i - k + 1] = maxHeap.peek();
            }
        }
        return output;
    }

    /**
     * 利用双端队列deque
     * 时间复杂度：O(N)
     * 题目的关键在于队列里面存储的是下标而不是元素值，这样可以解决窗口滑动的问题
     * 当前窗口下标范围:[i-k+1,i]
     * 1.移除不在窗口的值（remove，左边出队列）
     * 2.移除非最大值，使得最大值在队列左边首位（removeLast，右边出队列）
     * 3.元素入队列(add)
     * 4.放入结果
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return null;
        }
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (!deque.isEmpty() && i - k + 1 > deque.peek()) {
                deque.remove();
            }
            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0) {
                output[i - k + 1] = nums[deque.peek()];
            }
        }
        return output;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        printArray(maxSlidingWindow(nums, k));
        printArray(maxSlidingWindow2(nums, k));
        printArray(maxSlidingWindow3(nums, k));
    }
}
