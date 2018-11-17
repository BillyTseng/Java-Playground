package leet.Q01to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, curr, res);
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i != idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
