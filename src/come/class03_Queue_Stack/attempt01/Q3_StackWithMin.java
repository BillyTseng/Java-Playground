package come.class03_Queue_Stack.attempt01;

import java.util.Deque;
import java.util.LinkedList;

public class Q3_StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public Q3_StackWithMin() {
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
