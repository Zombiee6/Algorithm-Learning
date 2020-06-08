package leetcode;

import static leetcode.Util.printArray;

/**
 * 338. 比特位计数
 *
 * @author Billy
 * @date 2020/6/8 10:17 下午
 */
public class P338 {
    public static int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
//            System.out.println("i:" + i + ",i & i - 1:" + (i & i - 1));
            count[i] = count[i & i - 1] + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        printArray(countBits(2));
        printArray(countBits(5));
    }
}
