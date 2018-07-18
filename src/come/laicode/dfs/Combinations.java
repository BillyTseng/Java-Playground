package come.laicode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        combine(n, k, 1, cur, res);
        return res;
    }

    private void combine(int n, int k, int start, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            combine(n, k, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
