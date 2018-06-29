package come.class07_GraphII_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q2_AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, res, sb);
        return res;
    }

    private void helper(int n, int l, int r, List<String> res, StringBuilder sb) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            helper(n, l + 1, r, res, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            helper(n, l, r + 1, res, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
