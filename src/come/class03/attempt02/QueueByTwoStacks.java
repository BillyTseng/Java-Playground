package come.class03.attempt02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;
    public QueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        moveInToOutIfNecessary();
        return (out.isEmpty()) ? null : out.pollFirst();
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        moveInToOutIfNecessary();
        return (out.isEmpty()) ? null : out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }

    private void moveInToOutIfNecessary() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }
}
