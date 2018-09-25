package leet.a;

import java.util.Deque;
import java.util.LinkedList;

public class Q155_MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    public Q155_MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.offerFirst(x);
        if (min.isEmpty() || x <= min.peekFirst()) {
            min.offerFirst(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int curr = stack.pollFirst();
        if (curr == min.peekFirst()) {
            min.pollFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min.peekFirst();
    }
}
