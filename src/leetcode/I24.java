package leetcode;

/**
 * 面试题24. 反转链表
 *
 * @author Billy
 * @date 2020/4/1 10:07 下午
 */
public class I24 {
    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归
     * https://zhuanlan.zhihu.com/p/86745433
     *
     * @param head
     * @return
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNode(array);
        print(listNode);
//        print(reverseList(listNode));
        print(reverseListRecursive(listNode));
    }
}


