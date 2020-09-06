package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author Billy
 * @date 2020/8/16 6:07 下午
 */
public class P3 {
    /**
     * 快慢指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int res = 0;
        //如果快指针指向的字符已出现在set中，将慢指针指向的字符从set中删除
        for (int slow = 0, fast = 0; fast < chars.length; fast++) {
            while (set.contains(chars[fast])) {
                set.remove(chars[slow]);
                slow++;
            }
            set.add(chars[fast]);
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("pwwpkwew"));
    }
}
