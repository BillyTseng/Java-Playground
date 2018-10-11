package leet.a.freq;

import java.util.Random;

public class Q382_LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    private ListNode head;
    private Random rand;

    public Q382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int count = 0;
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            if (rand.nextInt(count) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
