package leetcode;

/**
 * 142. 环形链表 II
 *
 * @author Billy
 * @date 2020/7/22 6:48 下午
 */
public class P142 {
    /**
     * 用快慢指针先找到相遇点，把快指针放到队首，快慢指针每次同时前进1步，相遇点即为入环点。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
//        int[] array = {3, 2, 0, -4};
//        ListNode head = ListNode.getListNode(array);
//        System.out.println(detectCycle(head));
    }
}
