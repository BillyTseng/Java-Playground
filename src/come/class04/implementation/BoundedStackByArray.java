package come.class04.implementation;

public class BoundedStackByArray {
    private int head;
    private int size;
    private int[] array;
    BoundedStackByArray(int cap) {
        array = new int[cap];
        head = -1;
    }

    public boolean push(int value) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = value;
        size++;
        return true;
    }

    public Integer pop() {
        if (head == -1) {
            return null;
        }
        size--;
        return array[head--];
    }

    public Integer peek() {
        return head == -1 ? null : array[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

