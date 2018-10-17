package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(target, coins, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinations(int target, int[] coins, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (idx == coins.length - 1) {
            if (target % coins[idx] == 0) {
                curr.add(target / coins[idx]);
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }

        int max = target / coins[idx];
        for (int i = 0; i <= max; i++) {
            curr.add(i);
            combinations(target - i * coins[idx], coins, idx + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
