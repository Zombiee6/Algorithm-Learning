package leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author billy
 * @date 2020/11/18 10:11 上午
 */
public class P215 {
    private static final Random RANDOM = new Random();

    /**
     * 返回第K大，即数组从小到大排序之后的倒数第k个位置
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return 0;
        }
        return quickSearch(nums, 0, nums.length - 1, nums.length - k + 1);
//        return quickSearch2(nums, nums.length - k + 1);
        //返回第K小
//        return findK(nums, 0, nums.length - 1, k);
    }

    /**
     * 原理同P703，使用小顶堆保存数组中TopK大的元素，堆顶元素即为第K大元素
     * 时间复杂度：O(nlog(k))
     * 空间复杂度：O(k)
     */
    public static int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue(k);
        for (int num : nums) {
            int size = queue.size();
            if (size < k) {
                queue.offer(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    /**
     * 结合快排与二分查找思想
     * 时间复杂度：O(n)
     * 空间复杂度：使用了递归栈，O(log(n))
     */
    public static int quickSearch(int[] arr, int l, int r, int k) {
//        int p = partition(arr, l, r);
        //随机选择分区点
        int p = randomPartition(arr, l, r);
        if (p + 1 == k) {
            return arr[p];
        } else if (p + 1 < k) {
            return quickSearch(arr, p + 1, r, k);
        } else {
            return quickSearch(arr, l, p - 1, k);
        }
    }

    /**
     * 基于quickSearch，将递归改为迭代循环
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int quickSearch2(int[] arr, int k) {
        int p = partition(arr, 0, arr.length - 1);
        while (p + 1 != k) {
            if (p + 1 < k) {
                p = partition(arr, p + 1, arr.length - 1);
            } else {
                p = partition(arr, 0, p - 1);
            }
        }
        return arr[p];
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static int randomPartition(int[] a, int l, int r) {
        int i = RANDOM.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int k = 4;
        System.out.println(findKthLargest(nums, k));
//        printArray(nums);
    }
}
