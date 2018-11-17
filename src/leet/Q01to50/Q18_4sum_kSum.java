package leet.Q01to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_4sum_kSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSumI(int[] nums, int target) {
        List<List<Integer>> allSol = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return allSol;
        }
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums);
        kSum(nums, target, 0, nums.length - 1, 4, sol, allSol);
        return allSol;
    }

    private void kSum(int[] nums, int target, int start, int end, int k, List<Integer> sol, List<List<Integer>> allSol) {
        if (k <= 0) {
            return;
        }
        if (k == 1) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) {
                    sol.add(nums[i]);
                    allSol.add(new ArrayList<>(sol));
                    sol.remove(sol.size() - 1);
                    return;
                }
            }
        }
        if (k == 2) {
            twoSum(nums, target, start, end, sol, allSol);
            return;
        }

        for (int i = start; i <= end - k + 1; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            sol.add(nums[i]);
            kSum(nums, target - nums[i], i + 1, end, k - 1, sol, allSol);
            sol.remove(sol.size() - 1);
        }
    }

    private void twoSum(int[] nums, int target, int start, int end, List<Integer> sol, List<List<Integer>> allSol) {
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                sol.add(nums[start]);
                sol.add(nums[end]);
                allSol.add(new ArrayList<>(sol));
                sol.remove(sol.size() - 1);
                sol.remove(sol.size() - 1);
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}
