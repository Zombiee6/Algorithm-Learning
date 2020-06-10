package leetcode;

import static leetcode.Util.printArray;

/**
 * 338. 比特位计数
 *
 * @author Billy
 * @date 2020/6/8 10:17 下午
 */
public class P338 {
    /**
     * 动态规划+最后设置位
     * <p>
     * 状态转移函数：
     * P(x)=P(x&(x−1))+1;
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++) {
//            System.out.println("i:" + i + ",i & i - 1:" + (i & i - 1));
            count[i] = count[i & i - 1] + 1;
        }
        return count;
    }

    /**
     * 动态规划+最低有效位
     * <p>
     * 状态转移函数：
     * P(x)=P(x/2)+(x mod 2)
     *
     * @param num
     * @return
     */
    public static int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    /**
     * 奇数：比前面的偶数多一个1
     * 偶数：和除以2后的一样多
     *
     * @param num
     * @return
     */
    public static int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i >> 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        printArray(countBits(5));
        printArray(countBits2(5));
        printArray(countBits3(5));
    }
}
