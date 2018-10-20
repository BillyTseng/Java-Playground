package come.seattlePlan.linkedlist;

public class AddTwoNumbers {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += (l1 == null) ? 0 : l1.value;
            sum += (l2 == null) ? 0 : l2.value;
            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
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
