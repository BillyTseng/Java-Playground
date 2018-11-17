package leet.Q01to50;

public class Q2_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += (l1 == null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
