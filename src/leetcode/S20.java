package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author chenjie5
 * @date 2020/9/2 10:53 下午
 */
public class S20 {
    /**
     * 有限状态机
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
     */
    public static boolean isNumber(String s) {
        Map[] states = {
                // 0.
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},
                // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},
                // 2.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }},
                // 3.
                new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},
                // 4.
                new HashMap<Character,Integer>() {{ put('d', 3); }},
                // 5.
                new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},
                // 6.
                new HashMap<Character,Integer>() {{ put('d', 7); }},
                // 7.
                new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},
                // 8.
                new HashMap<Character,Integer>() {{ put(' ', 8); }}
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                t = 'd';
            } else if(c == '+' || c == '-') {
                t = 's';
            } else if(c == 'e' || c == 'E') {
                t = 'e';
            } else if(c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if(!states[p].containsKey(t)) {
                return false;
            }
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("+.8"));
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber("-100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1416"));
        System.out.println(isNumber("-1E-16"));
        System.out.println("-------------------");
        System.out.println(isNumber(".e1"));
        System.out.println(isNumber("e9"));
        System.out.println(isNumber("12e"));
        System.out.println(isNumber("1a3.14"));
        System.out.println(isNumber("1.2.3"));
        System.out.println(isNumber("+-5"));
        System.out.println(isNumber("12e+5.4"));

    }
}
