package come.class03;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public StackWithMin() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int ret = stack.pop();
        if (!minStack.isEmpty() && ret == minStack.peek()) {
            minStack.poll();
        }
        return ret;
    }

    public void push(int element) {
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
        stack.push(element);
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
