package come.planMV.strings;

import java.util.Deque;
import java.util.LinkedList;

/* https://leetcode.com/problems/valid-parentheses/ easy */

public class ValidParenthese {
    public boolean isValid(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.offerFirst(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pollFirst() != '(') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pollFirst() != '[') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pollFirst() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
