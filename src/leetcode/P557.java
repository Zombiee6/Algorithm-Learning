package leetcode;

/**
 * @author chenjie5
 * @date 2020/8/30 3:57 下午
 */
public class P557 {
    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
