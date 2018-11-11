package leet.topics.firms.a;

public class Q160_IntersectionTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode one = head1;
        ListNode two = head2;
        while (one != two) {
            one = (one == null) ? head2 : one.next;
            two = (two == null) ? head1 : two.next;
        }
        return one;
    }
}
