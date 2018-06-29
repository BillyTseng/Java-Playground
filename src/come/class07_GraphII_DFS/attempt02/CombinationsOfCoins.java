package come.class07_GraphII_DFS.attempt02;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        helper(target, coins, res, comb, 0);
        return res;
    }

    private void helper(int target, int[] coins, List<List<Integer>> res, List<Integer> comb, int idx) {
        if (idx == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                comb.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(comb));
                comb.remove(comb.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= target / coins[idx]; i++) {
            comb.add(i);
            helper(target - i * coins[idx], coins, res, comb, idx + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
