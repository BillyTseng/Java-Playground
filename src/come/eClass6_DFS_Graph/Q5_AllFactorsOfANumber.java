package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.List;

public class Q5_AllFactorsOfANumber {
    public List<List<Integer>> factors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        factors(n, 2, new ArrayList<>(), res);
        return res;
    }

    private void factors(int target, int lastDigit, List<Integer> cur, List<List<Integer>> res) {
        if (target == 1) {
            if (cur.size() >= 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = lastDigit; i <= target; i++) {
            if (target % i == 0) {
                cur.add(i);
                factors(target / i, i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
