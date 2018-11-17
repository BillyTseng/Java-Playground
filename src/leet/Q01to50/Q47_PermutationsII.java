package leet.Q01to50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, 0, res);
        return res;
    }

    private void permuteUnique(int[] nums, int idx, List<List<Integer>> res) {
        if (nums.length == idx) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, idx, i);
                permuteUnique(nums, idx + 1, res);
                swap(nums, idx, i);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
