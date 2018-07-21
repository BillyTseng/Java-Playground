package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.List;

public class Q2_1b_TwoSubsetsWithMinDifference {
    public int minDifference(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] min = new int[] {Integer.MAX_VALUE};
        int totalSum = 0;

        for (int num : array) {
            totalSum += num;
        }

        minDifference(array, min, 0, new ArrayList<>(), totalSum, 0);
        return min[0];
    }

    private void minDifference(int[] input, int[] min, int idx, List<Integer> currSet, int totalSum, int currSum) {
        if (idx == input.length) {
          return;
        }

        if (currSet.size() == input.length / 2) {
            min[0] = Math.min(min[0], Math.abs((totalSum - currSum) - currSum));
            return;
        }

        currSet.add(input[idx]);
        currSum += input[idx];
        minDifference(input, min, idx + 1, currSet, totalSum, currSum);
        currSum -= input[idx];
        currSet.remove(currSet.size() - 1);
        minDifference(input, min, idx + 1, currSet, totalSum, currSum);
    }
}
