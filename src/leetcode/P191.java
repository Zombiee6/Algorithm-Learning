package leetcode;

/**
 * 191. 位1的个数
 *
 * @author Billy
 * @date 2020/6/3 10:18 下午
 */
public class P191 {
    /**
     * 遍历整型的32位。如果某一位是1，将计数器加一。
     * 任何数字跟掩码1进行逻辑与运算，都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
     * <p>
     * 时间复杂度 : O(1)
     * 空间复杂度 : O(1)
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int bits = 0;
        //位掩码
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /**
     * 清零最低位的1，结果加1，当n=0时就没有1的位，此时返回结果
     *
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(9));
        System.out.println(hammingWeight2(-3));
        System.out.println(hammingWeight2(9));
    }
}
