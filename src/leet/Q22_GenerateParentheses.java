package leet;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append('(');
            dfs(n, l + 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(')');
            dfs(n, l, r + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
