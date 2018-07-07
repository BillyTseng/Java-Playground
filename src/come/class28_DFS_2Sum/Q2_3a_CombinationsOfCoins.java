package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.List;

public class Q2_3a_CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        combinations(target, coins, 0, cur, res);
        return res;
    }

    private void combinations(int target, int[] coins, int level, List<Integer> cur, List<List<Integer>> res) {
        if (level == coins.length - 1) {
            if (target % coins[level] == 0) {
                cur.add(target / coins[level]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[level];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            combinations(target - (i * coins[level]), coins, level + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
