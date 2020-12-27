package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author billy
 * @date 2020/12/23 5:12 下午
 */
public class P387 {
    /**
     * 利用map记录次数,遍历两次
     * 时间复杂度：O(n)
     * 空间复杂度：O(k) k为字符集数量
     */
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap(128);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer cnt = map.getOrDefault(c, 0);
            map.put(c, ++cnt);
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组记录出现次数，仅适用于字符串为小写字母的场景
     * 时间复杂度：O(n)
     * 空间复杂度：O(k) k为字符集数量
     */
    public int firstUniqChar2(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 借助String api，写法简单但复杂度高
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        String str = "leetcode";
        String str = "loveleetcode";
        System.out.println(firstUniqChar(str));
    }
}
