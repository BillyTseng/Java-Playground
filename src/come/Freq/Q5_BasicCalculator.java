package come.Freq;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. Basic Calculator - hard
 */

public class Q5_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int number = 0, result = 0, sign = 1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (int)(ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.offerFirst(result);
                stack.offerFirst(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                sign = 1;
                result *= stack.pollFirst();
                result += stack.pollFirst();
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
