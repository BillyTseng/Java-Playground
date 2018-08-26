package come.Freq;

/**
 * 138. Copy List with Random Pointer - medium
 *
 */

public class Q28_CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    // Time O(n), space O(1); Using HashMap, time O(n), space O(n)
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // first round, make the copy node and insert it after the orginal node.
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

        // second round, link the random reference of the copied nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // final round, extract the copied nodes.
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyPrev = dummy;
        curr = head;
        while (curr != null) {
            copyPrev.next = curr.next;
            copyPrev = copyPrev.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
