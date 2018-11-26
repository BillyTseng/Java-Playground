package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        subsets(nums, new ArrayList<>(), res, 0);
        return res;
    }

    private void subsets(int[] nums, List<Integer> item, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }

        item.add(nums[idx]);
        subsets(nums, item, res, idx + 1);
        item.remove(item.size() - 1);

        subsets(nums, item, res, idx + 1);
    }
}
