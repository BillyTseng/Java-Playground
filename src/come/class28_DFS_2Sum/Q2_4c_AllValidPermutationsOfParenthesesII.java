package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q2_4c_AllValidPermutationsOfParenthesesII {
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = l * 2 + m * 2 + n * 2;
        Deque<Character> stack = new LinkedList<>();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        validParentheses(sb, stack, targetLen, remain, res);
        return res;
    }

    private void validParentheses(StringBuilder sb, Deque<Character> stack, int targetLen, int[] remain, List<String> res) {
        if (targetLen == sb.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    validParentheses(sb, stack, targetLen, remain, res);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    validParentheses(sb, stack, targetLen, remain, res);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}
