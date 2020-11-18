package leetcode;

/**
 * 69. x 的平方根
 *
 * @author Billy
 * @date 2020/5/7 12:07 上午
 */
public class P69 {
    /**
     * 利用二分查找实现
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x, res = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            //m*m会导致int越位
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    /**
     * 递归+位操作
     * <p>
     * 本方的思路是使用递归,每一步都减小x,直到x<2。当x<2时有sqrt(x)=x
     * 递归公式：mySqrt(x)=2*mySqrt(x/4)
     * 移位：x<<y表示x*2^y，x>>y表示x*2^(-y)，因此递归公式可以写成mySqrt(x)=mySqrt(x>>2)<<1
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(logN)
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x < 2) {
            return x;
        }
        int left = mySqrt2(x >> 2) << 1;
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }

    /**
     * 指定精度
     *
     * @param x
     * @param epsilon
     * @return
     */
    public static double mySqrt(int x, double epsilon) {
        if (x == 0 || x == 1) {
            return x;
        }
        double l = 1, r = x, res = 0;
        while (l <= r) {
            double m = (l + r) / 2;
            //m*m会导致int越位
            if (Math.abs(m * m - x) < epsilon) {
                return m;
            } else if (m * m > x) {
                r = m;
            } else {
                l = m;
            }
        }
        return res;
    }

    /**
     * 牛顿法
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param x
     * @return
     */
    public static int mySqrt3(int x) {
        if (x < 2) {
            return x;
        }
        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }
        return (int) x1;
    }

    /**
     * 牛顿迭代法求平方根
     * @param  number   求值的数
     * @param  accuracy 精度
     * @return          Double
     */
    public static double NewtonSqrt(double number, double accuracy) {
        //第一个猜测值
        double guess = number / 2;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        //当两个猜测的差值大于精度即return
        while (Math.abs(guess - (number / guess)) > accuracy) {
            //迭代公式推导而成
            guess = (guess + (number / guess)) / 2;
            count++;
            System.out.printf("try count = %d, guess = %f\n", count, guess);
        }
        System.out.printf("final result = %f\n", guess);
        return guess;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(2, 0.1));
    }
}
