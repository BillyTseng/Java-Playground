package come.class04_Linked_List.attempt01;

public class Q9_CheckIfLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        return isIdentical(head, reverse(right));
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private boolean isIdentical(ListNode left, ListNode right) {
        while (left != null && right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
