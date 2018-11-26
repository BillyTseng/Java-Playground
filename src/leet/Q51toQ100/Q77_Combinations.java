package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k) {
            return res;
        }
        combine(1, new ArrayList<>(), res, k, n);
        return res;
    }

    private void combine(int start, List<Integer> curr, List<List<Integer>> res, int k, int n) {
        if (k == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            combine(i + 1, curr, res, k, n);
            curr.remove(curr.size() - 1);
        }
    }
}
