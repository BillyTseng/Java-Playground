package leet.Q01to50;

import java.util.ArrayList;
import java.util.List;

public class Q39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<>();

        combinationSum(candidates, target, 0, curr, res);
        return res;
    }

    private void combinationSum(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
