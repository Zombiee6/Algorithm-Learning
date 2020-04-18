package leetcode;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * @author Billy
 * @date 2020/4/1 11:03 下午
 */
public class P20 {
    /**
     * stack实现
     *
     * @param str
     * @return
     */
    public static boolean isValid(String str) {
        //判断是否为奇数
//        if ((str.length() & 1) == 1) {
        if (str.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(3) {{
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

    /**
     * 递归实现
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            return isValid2(s.replace("()", "").replace("[]", "").replace("{}", ""));
        } else {
            return "".equals(s);
        }
    }

    /**
     * 利用ASCII码，省去Map
     *
     * @param s
     * @return
     */
    public static boolean isValid3(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // '('，')'，'{'，'}'，'['，']' 的 ASCII 码分别是 40、41、91、93、123、125
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (stack.isEmpty() || Math.abs(ch - stack.pop()) > 2) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * short java solution
     *
     * @param s
     * @return
     */
    public static boolean isValid4(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String str = "()[]{}";
//        String str = "([)]";
        System.out.println(isValid(str));
        System.out.println(isValid2(str));
        System.out.println(isValid3(str));
        System.out.println(isValid4(str));
    }
}
