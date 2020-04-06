package leetcode;

/**
 * @author Billy
 * @date 2020/4/6 9:28 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode getListNode(int[] array) {
        ListNode head = null;
        for (int i = array.length - 1; i >= 0; i--) {
            int val = array[i];
            ListNode node = new ListNode(val);
            if (head != null) {
                node.next = head;
            }
            head = node;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}