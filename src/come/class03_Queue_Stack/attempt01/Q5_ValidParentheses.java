package come.class03_Queue_Stack.attempt01;

import java.util.Deque;
import java.util.LinkedList;

public class Q5_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Q5_ValidParentheses solution = new Q5_ValidParentheses();
        String test = "[]";
        System.out.println(solution.isValid(test));
    }
}
