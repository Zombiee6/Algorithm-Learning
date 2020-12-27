package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * s->t存在唯一映射，t->s存在唯一映射，即双射关系。注意：不是唯一映射
 *
 * @author billy
 * @date 2020/12/27 8:05 下午
 */
public class P205 {

    /**
     * 时间复杂度 : O(n*k) k为字符串字符集大小
     * 空间复杂度 : O(k)
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dict = new HashMap(26);
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!dict.containsKey(sChar)) {
                //containsValue为线性时间复杂度，等于map size
                if (dict.containsValue(tChar)) {
                    return false;
                }
                dict.put(sChar, tChar);
            } else if (dict.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用两张哈希表记录映射关系
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(k)
     */
    public static boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) ||
                    (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "egg", t = "add";
//        String s = "paper", t = "title";
        String s = "ab", t = "aa";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic2(s, t));
    }
}
