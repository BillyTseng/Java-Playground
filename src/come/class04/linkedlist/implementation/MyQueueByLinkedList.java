package come.class04.linkedlist.implementation;

public class MyQueueByLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public void offer(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    public Integer poll() {
        if (head == null) {
            return null;
        }
        ListNode ret = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        ret.next = null;
        size--;
        return ret.value;
    }
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}

