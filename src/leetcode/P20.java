package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author Billy
 * @date 2020/4/1 11:03 下午
 */
public class P20 {
    public static boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                Character chr = map.get(c);
                if (stack.isEmpty() || !stack.pop().equals(chr)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String str = "()[]{}";
        String str = "([)]";
        System.out.println(isValid(str));
    }
}
