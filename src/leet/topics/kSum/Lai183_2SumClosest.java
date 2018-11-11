package leet.topics.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lai183_2SumClosest {
    public List<Integer> closest(int[] array, int target) {
        List<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        Arrays.sort(array);
        int i = 0, j = array.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == target) {
                return Arrays.asList(array[i], array[j]);
            } else if (sum < target) {
                minDiff = updateMinDiffIdx(minDiff, res, target - sum, array[i], array[j]);
                i++;
            } else {
                minDiff = updateMinDiffIdx(minDiff, res, sum - target, array[i], array[j]);
                j--;
            }
        }
        return res;
    }

    private int updateMinDiffIdx(int minDiff, List<Integer> res, int newDiff, int one, int two) {
        int temp = minDiff;
        minDiff = Math.min(minDiff, newDiff);
        if (temp != minDiff) {
            res.set(0, one);
            res.set(1, two);
        }
        return minDiff;
    }
}
