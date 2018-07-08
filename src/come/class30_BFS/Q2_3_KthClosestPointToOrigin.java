package come.class30_BFS;

import java.util.*;

public class Q2_3_KthClosestPointToOrigin {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long dist1 = distance(o1, a, b, c);
                long dist2 = distance(o2, a, b, c);
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
            if (n.get(2) < c.length && visited.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        curr.set(0, a[curr.get(0)]);
        curr.set(1, b[curr.get(1)]);
        curr.set(2, c[curr.get(2)]);
        return curr;
    }

    private long distance(List<Integer> curr, int[] a, int[] b, int[] c) {
        long dist = 0;
        dist += a[curr.get(0)] * a[curr.get(0)];
        dist += b[curr.get(1)] * b[curr.get(1)];
        dist += c[curr.get(2)] * c[curr.get(2)];
        return dist;
    }
}
