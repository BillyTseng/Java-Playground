package come.class03.attempt02;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public StackWithMin() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int res = stack.pollFirst();
        if (!min.isEmpty() && res == min.peekFirst()) {
            min.pollFirst();
        }
        return res;
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (min.isEmpty() || element <= min.peekFirst()) {
            min.offerFirst(element);
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peekFirst();
    }

    public int min() {
        return min.isEmpty() ? -1 : min.peekFirst();
    }
}
