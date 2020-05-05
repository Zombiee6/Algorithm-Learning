package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author Billy
 * @date 2020/4/30 9:24 下午
 */
public class P22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        genParenthesis("", result, n, n);
        return result;
    }

    public static void genParenthesis(String str, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            genParenthesis(str + "(", result, left - 1, right);
        }
        if (right > left) {
            genParenthesis(str + ")", result, left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
