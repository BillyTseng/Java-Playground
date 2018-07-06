package come.class28_DFS_2Sum;

/* https://code.laioffer.com/ui/#/app/problem/404 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_3b_FactorCombinations {
    private List<List<Integer>> combinations(int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            return res;
        }

        List<Integer> curr = new ArrayList<>();
        combinations(target, 2, curr, res);
        return res;
    }

    private void combinations(int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 1 && curr.size() > 1) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= target; i++) {
            if (target % i == 0) {
                curr.add(i);
                combinations(target / i, i, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q2_3b_FactorCombinations solution = new Q2_3b_FactorCombinations();

        List<List<Integer>> answer = solution.combinations(24);
        for (List<Integer> list : answer) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
