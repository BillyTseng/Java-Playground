package come.eClass10_Intervals;

import java.util.*;

public class Q6_TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        for (int[] b : buildings) {
            // Add the negative height of start of building.
            heights.add(new int[] {b[0], -b[2]});
            // Add the height of end of building.
            heights.add(new int[] {b[1], b[2]});
        }

        heights.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        return 0;
                    }
                    return a[1] < b[1] ? -1 : 1;
                }
                return a[0] < b[0] ? -1 : 1;
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                maxHeap.offer(-h[1]);
            } else {
                maxHeap.remove(h[1]);
            }

            int cur = maxHeap.peek();
            if (prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
