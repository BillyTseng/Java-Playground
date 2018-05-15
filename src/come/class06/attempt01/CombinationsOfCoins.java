package come.class06.attempt01;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<Integer> sol = new ArrayList<>(coins.length);
        List<List<Integer>> res = new ArrayList<>();
        helper(target, coins, sol, res, 0);
        return res;
    }

    private void helper(int moneyLeft, int[] coins, List<Integer> sol, List<List<Integer>> res, int level) {
        if (level == coins.length - 1) {
            if (moneyLeft % coins[level] == 0) {
                sol.add(moneyLeft / coins[level]);
                res.add(new ArrayList<Integer>(sol));
                sol.remove(sol.size() - 1);
            }
            return;
        }
        int max = moneyLeft / coins[level];
        for (int i = 0; i <= max; i++) {
            sol.add(i);
            helper(moneyLeft - i * coins[level], coins, sol, res, level + 1);
            sol.remove(sol.size() - 1);
        }
    }
}
