package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * @author Billy
 * @date 2020/4/8 1:06 上午
 */
public class P242 {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = smap.get(c) == null ? 0 : smap.get(c);
            smap.put(c, cnt + 1);
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int cnt = tmap.get(c) == null ? 0 : tmap.get(c);
            tmap.put(c, cnt + 1);
        }
        return smap.equals(tmap);
    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)(counter大小26是常数)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
