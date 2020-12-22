package leetcode;

import java.util.Random;

import static leetcode.Util.printArray;

/**
 * 912. 排序数组
 *
 * @author billy
 * @date 2020/12/22 5:09 下午
 */
public class P912 {
    private static final Random RANDOM = new Random();

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快排
     * 时间复杂度：O(nlog(n))
     * 空间复杂度：使用了递归栈，O(log(n))
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int p = RANDOM.nextInt(r - l + 1) + l;
        swap(arr, r, p);
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] nums = {3, -1};
        printArray(sortArray(nums));
    }
}
