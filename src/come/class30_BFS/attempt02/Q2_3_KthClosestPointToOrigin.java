package come.class30_BFS.attempt02;

import java.util.*;

public class Q2_3_KthClosestPointToOrigin {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                long dist1 = distance(p1, a, b, c);
                long dist2 = distance(p2, a, b, c);
                if (dist1 == dist2) {
                    return 0;
                }
                return dist1 < dist2 ? -1 : 1;
            }
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> curr = Arrays.asList(0, 0, 0);
        minHeap.offer(curr);
        visited.add(curr);

        while (k > 0) {
            curr = minHeap.poll();
            List<Integer> n = Arrays.asList(curr.get(0) + 1, curr.get(1), curr.get(2));
            if (n.get(0) < a.length && visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(curr.get(0), curr.get(1) + 1, curr.get(2));
            if (n.get(1) < b.length && visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(curr.get(0), curr.get(1), curr.get(2) + 1);
            if (n.get(2) < b.length && visited.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        return Arrays.asList(a[curr.get(0)], b[curr.get(1)], c[curr.get(2)]);
    }

    private long distance(List<Integer> input, int[] a, int[] b, int[] c) {
        long distance = 0;
        distance += a[input.get(0)] * a[input.get(0)];
        distance += b[input.get(1)] * b[input.get(1)];
        distance += c[input.get(2)] * c[input.get(2)];
        return distance;
    }
}
