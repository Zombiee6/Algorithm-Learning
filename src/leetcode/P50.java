package leetcode;

/**
 * 50. Pow(x, n)
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31-1]
 *
 * @author Billy
 * @date 2020/4/20 9:33 下午
 */
public class P50 {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //-2147483648<=n<=2147483647,防止Int越位
        if (n == Integer.MIN_VALUE) {
            return 1.0 / (x * myPow(x, -(n + 1)));
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
//        if (n % 2 == 0) {
//            return myPow(x * x, n / 2);
//        } else {
//            return x * myPow(x, n - 1);
//        }
    }

    /**
     * 快速幂算法（递归）
     * 时间复杂度：O(log n)
     * 空间复杂度：O(log n)
     */
    public static double Pow2(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1.0 / x;
            N = -N;
        }
        return recursionPow(x, N);
    }

    public static double recursionPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = recursionPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
//        if (n % 2 == 0) {
//            return myPow(x * x, n / 2);
//        } else {
//            return x * myPow(x, n - 1);
//        }
    }

    /**
     * 暴力法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

    /**
     * 快速幂算法（循环）
     * 时间复杂度：O(logn)
     * 空间复杂的：O(1)
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow4(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1.0 / x;
        }
        double ans = 1;
        double tmp = x;
        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                ans = ans * tmp;
            }
            tmp = tmp * tmp;
        }
        return ans;
    }

    //栈溢出
//    public static double Pow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        } else if (n < 0) {
//            return 1.0 / x * myPow(x, n + 1);
//        } else {
//            return x * myPow(x, n - 1);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0.00001, -2147483648));
        System.out.println(myPow(2, -2147483648));
//        System.out.println(myPow(0.00001, 2147483647));
    }
}
