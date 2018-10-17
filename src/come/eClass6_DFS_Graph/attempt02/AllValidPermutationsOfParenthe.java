package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParenthe {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private void dfs(int n, int l, int r, List<String> res, StringBuilder sb) {
        if (l == n && n == r) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            dfs(n, l + 1, r, res, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            dfs(n, l, r + 1, res, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
