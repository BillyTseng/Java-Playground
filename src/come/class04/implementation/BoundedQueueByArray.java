package come.class04.implementation;

public class BoundedQueueByArray {
    private int head;
    private int tail;
    private int size;
    private int[] array;
    BoundedQueueByArray(int cap) {
        array = new int[cap];
    }

    public boolean offer(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[head];
        head = (head + 1) % array.length;
        size--;
        return ret;
    }

    public Integer peek() {
	    if (size == 0) {
            return null;
        }
        return array[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

