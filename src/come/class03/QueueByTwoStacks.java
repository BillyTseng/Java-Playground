package come.class03;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    Deque<Integer> in;
    Deque<Integer> out;
    public QueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        moveIfNecessary();
        return out.isEmpty() ? null : out.poll();
    }

    public void offer(int element) {
        in.push(element);
    }

    public Integer peek() {
        moveIfNecessary();
        return out.isEmpty() ? null : out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void moveIfNecessary() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

}
