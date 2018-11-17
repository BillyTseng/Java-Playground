package leet.Q01to50;

import java.util.Deque;
import java.util.LinkedList;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.offerFirst(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char polledChar = stack.pollFirst();
                if (polledChar == '(' && ch != ')') {
                    return false;
                }
                if (polledChar == '{' && ch != '}') {
                    return false;
                }
                if (polledChar == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
