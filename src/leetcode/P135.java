package leetcode;

/**
 * 135. 分发糖果
 *
 * @author billy
 * @date 2020/12/24 10:02 下午
 */
public class P135 {

    /**
     * 设学生A和学生B左右相邻，A在B左边
     * 左规则：当ratings_B>ratings_A时，B的糖比A的糖数量多。
     * 右规则：当ratings_A>ratings_B时，A的糖比B的糖数量多。
     * 取满足左、右规则的最大者
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    /**
     * 基于candy优化，用单个变量记录当前位置的右规则，同时计算答案
     */
    public static int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int right = 0, res = 0;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 0, 2};
        System.out.println(candy(ratings));
        System.out.println(candy2(ratings));
    }
}
