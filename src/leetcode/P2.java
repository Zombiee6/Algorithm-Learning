package leetcode;

/**
 * 2. 两数相加
 *
 * @author Billy
 * @date 2020/3/30 8:42 下午
 */
public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        int val = l1.val + l2.val;
        if (val >= 10) {
            val = val % 10;
            step = 1;
        } else {
            step = 0;
        }
        ListNode head = new ListNode(val);
        ListNode temp = head;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            int newVal = l1.val + l2.val + step;
            if (newVal >= 10) {
                newVal = newVal % 10;
                step = 1;
            } else {
                step = 0;
            }
            ListNode node = new ListNode(newVal);
            temp.next = node;
            temp = node;
        }

        while (l1.next != null) {
            l1 = l1.next;
            int newVal = l1.val + step;
            if (newVal >= 10) {
                newVal = newVal % 10;
                step = 1;
            } else {
                step = 0;
            }
            ListNode node = new ListNode(newVal);
            temp.next = node;
            temp = node;
        }

        while (l2.next != null) {
            l2 = l2.next;
            int newVal = l2.val + step;
            if (newVal >= 10) {
                newVal = newVal % 10;
                step = 1;
            } else {
                step = 0;
            }
            ListNode node = new ListNode(newVal);
            temp.next = node;
            temp = node;
        }

        if (step == 1) {
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
//        while (l1 != null || l2 != null || carry != 0) {
        while (!(l1 == null && l2 == null && carry == 0)) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 4, 3};
//        int[] a1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] a2 = {5, 6, 4};
//        int[] a1 = {9};
//        int[] a2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = ListNode.getListNode(a1);
        ListNode l2 = ListNode.getListNode(a2);
        System.out.println(addTwoNumbers2(l1, l2));
    }
}


