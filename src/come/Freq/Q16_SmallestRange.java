package come.Freq;

import java.util.List;
import java.util.PriorityQueue;

public class Q16_SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minX = 0, minY = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = true;
        int[] idxOfLists = new int[nums.size()];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i, j) -> {
            return Integer.compare(nums.get(i).get(idxOfLists[i]), nums.get(j).get(idxOfLists[j]));
        });

        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(i);
            max = Math.max(max, nums.get(i).get(idxOfLists[i]));
        }

        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int idxWithMinValue = minHeap.poll();
                int currentMinValue = nums.get(idxWithMinValue).get(idxOfLists[idxWithMinValue]);

                if (minY - minX > max - currentMinValue) {
                    minX = currentMinValue;
                    minY = max;
                }

                idxOfLists[idxWithMinValue]++;

                if (idxOfLists[idxWithMinValue] == nums.get(idxWithMinValue).size()) {
                    flag = false;
                    break;
                }
                minHeap.offer(idxWithMinValue);
                max = Math.max(max, nums.get(idxWithMinValue).get(idxOfLists[idxWithMinValue]));
            }
        }
        return new int[] {minX, minY};
    }
}
