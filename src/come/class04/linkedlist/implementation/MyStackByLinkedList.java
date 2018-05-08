package come.class04.linkedlist.implementation;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class MyStackByLinkedList {
    private ListNode head;
    private int size;

    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode ret = head;
        head = head.next;
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

