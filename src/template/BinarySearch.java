package template;

/**
 * @author Billy
 * @date 2020/7/21 7:57 上午
 */
public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            //在固定类型变量的语言中， left + right 可能会导致 int 越界
            //int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
