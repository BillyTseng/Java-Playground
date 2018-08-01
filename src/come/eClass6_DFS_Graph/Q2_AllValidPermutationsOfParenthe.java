package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.List;

public class Q2_AllValidPermutationsOfParenthe {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        validParentheses(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private void validParentheses(int n, int l, int r, List<String> res, StringBuilder sb) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            validParentheses(n, l + 1, r, res, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            validParentheses(n, l, r + 1, res, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
