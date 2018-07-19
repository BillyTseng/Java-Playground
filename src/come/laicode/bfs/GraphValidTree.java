package come.laicode.bfs;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : graph.get(cur)) {
                if (!visited.add(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
            }
        }
        return (n == visited.size());
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
