package come.eClass2_LinkedList_BinarySearch.attempt02;

import java.util.HashSet;
import java.util.Set;

public class Q1_3_2_IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode one, ListNode two) {
        Set<ListNode> set = new HashSet<>();
        while (one != null) {
            set.add(one);
            one = one.next;
        }

        ListNode res = null;
        while (two != null) {
            if (!set.add(two)) {
                res = two;
                break;
            }
            two = two.next;
        }
        return res;
    }
}
