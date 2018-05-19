package come.class06.attempt02;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        helper(n, res, new StringBuilder(), 0, 0);
        return res;
    }

    private void helper(int n, List<String> res, StringBuilder sb, int l, int r) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append('(');
            helper(n, res, sb, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(')');
            helper(n, res, sb, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
