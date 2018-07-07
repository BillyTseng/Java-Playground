package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.List;

public class Q2_4a_AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        validParentheses(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void validParentheses(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (n == l && n == r) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            validParentheses(n, l + 1, r, sb.append('('), res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            validParentheses(n, l, r + 1, sb.append(')'), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
