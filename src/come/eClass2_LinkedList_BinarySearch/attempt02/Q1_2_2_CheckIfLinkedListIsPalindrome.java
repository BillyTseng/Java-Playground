package come.eClass2_LinkedList_BinarySearch.attempt02;

public class Q1_2_2_CheckIfLinkedListIsPalindrome {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode midNode = findMid(head);
        ListNode two = midNode.next;
        midNode.next = null;
        return isTwoListEqual(head, reverse(two));
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

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

    private boolean isTwoListEqual(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.value != two.value) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return true;
    }
}
