package leet.a;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q682_BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : ops) {
            int num = 0;
            char ch = str.charAt(0);
            if (ch == 'D') {
                if (!stack.isEmpty()) {
                    num = stack.peekFirst() * 2;
                }
                stack.offerFirst(num);
            } else if (ch == 'C') {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            } else if (ch == '+') {
                int top = stack.pollFirst();
                int newTop = top + stack.peekFirst();
                stack.offerFirst(top);
                stack.offerFirst(newTop);
            } else if (ch == '-' || Character.isDigit(ch)) {
                int startPos = 0;
                if (ch == '-') {
                    startPos = 1;
                }

                for (int i = startPos; i < str.length(); i++) {
                    num = num * 10 + (str.charAt(i) - '0');
                }

                if (ch == '-') {
                    num = 0 - num;
                }
                stack.offerFirst(num);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pollFirst();
        }
        return sum;
    }
}
