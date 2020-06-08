package leetcode;

/**
 * 231. 2的幂
 *
 * @author Billy
 * @date 2020/6/8 10:07 下午
 */
public class P231 {
    /**
     * 若n=2^x,则恒有n & (n - 1) == 0
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }
}
