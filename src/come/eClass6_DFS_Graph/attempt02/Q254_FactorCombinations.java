package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.List;

public class Q254_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        getFactors(n, 2, ans, res);
        return res;
    }

    private void getFactors(int n, int factor, List<Integer> ans, List<List<Integer>> res) {
        if (n == 1) {
            if (ans.size() > 1) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        for (int i = factor; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                getFactors(n / i, i, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
