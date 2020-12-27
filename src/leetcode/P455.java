package leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author billy
 * @date 2020/12/25 5:30 下午
 */
public class P455 {

    /**
     * 排序+贪心
     * 时间复杂度 : O(n^2)
     * 空间复杂度 : O(logm+logn) 排序
     */
    public static int findContentChildren(int[] g, int[] s) {
        //sort
        Arrays.sort(g);
        Arrays.sort(s);
        //greedy
        int i = 0, j = 0, res = 0;
        for (; i < g.length; i++) {
            for (; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    res++;
                    j++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 最优：基于findContentChildren优化代码
     */
    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //g的索引
        int i = 0;
        //s的索引
        int j = 0;
        while (i < g.length && j < s.length) {
            //只有满足条件，才能喂好孩子
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] g=new int[]{1,2,3};
//        int[] s=new int[]{1,1};
        int[] g = new int[]{1};
        int[] s = new int[]{3, 21, 1};
        System.out.println(findContentChildren(g, s));
    }
}
