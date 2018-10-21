package come.seattlePlan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> currLevel = new ArrayList<>();
        combinationSum(candidates, target, currLevel, res, 0);
        return res;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> currLevel, List<List<Integer>> res, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(currLevel));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                currLevel.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], currLevel, res, i);
                currLevel.remove(currLevel.size() - 1);
            }
        }
    }
}
