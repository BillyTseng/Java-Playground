package leet;

import java.util.PriorityQueue;

public class Q23_MergeKsortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        for (ListNode node : lists) {
            minHeap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode polledNode = minHeap.poll();
            if (polledNode.next != null) {
                minHeap.offer(polledNode.next);
            }

            curr.next = polledNode;
            curr = curr.next;
        }
        return dummy.next;
    }
}
