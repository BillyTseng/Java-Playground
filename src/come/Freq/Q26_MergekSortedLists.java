package come.Freq;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * k i s number of List Node, n is the average length of the lists
 * Time O(n * logk), Space O(k)
 */

public class Q26_MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode polledNode = minHeap.poll();
            curr.next = polledNode;
            curr = curr.next;
            if (polledNode.next != null) {
                minHeap.offer(polledNode.next);
            }
        }

        return dummy.next;
    }

    private class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val == n2.val) {
                return 0;
            }
            return n1.val < n2.val ? -1 : 1;
        }
    }
}
