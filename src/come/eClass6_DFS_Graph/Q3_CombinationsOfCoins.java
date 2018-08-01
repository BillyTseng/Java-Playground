package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.List;

public class Q3_CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(target, coins, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinations(int target, int[] coins, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }

        int max = target / coins[idx];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            combinations(target - coins[idx] * i, coins, idx + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
