package come.class03_Queue_Stack.attempt01;

import java.util.Deque;
import java.util.LinkedList;

public class Q4_EvaluateReversePolishNotation {
    private int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return 0;
        }
        String operators = "+-*/";
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                if (stack.isEmpty()) {
                    // invalid Reverse Polish Notation
                    return 0;
                }
                int e2 = stack.pop();
                int e1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(e1 + e2);
                        break;
                    case "-":
                        stack.push(e1 - e2);
                        break;
                    case "*":
                        stack.push(e1 * e2);
                        break;
                    case "/":
                        stack.push(e1 / e2);
                        break;
                }
            }

        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Q4_EvaluateReversePolishNotation solution = new Q4_EvaluateReversePolishNotation();
        String[] tokens = new String[] {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));


        tokens = new String[] {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}
