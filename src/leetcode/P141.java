package leetcode;

/**
 * 141. 环形链表
 *
 * @author Billy
 * @date 2020/4/6 9:27 下午
 */
public class P141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 0, -4};
        ListNode head = ListNode.getListNode(array);
        System.out.println(hasCycle(head));
    }
}
