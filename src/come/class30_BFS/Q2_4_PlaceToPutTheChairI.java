package come.class30_BFS;

import java.util.*;

public class Q2_4_PlaceToPutTheChairI {
    private static final char EQUIPMENT = 'E';
    private static final char OBSTACLE = 'O';

    public List<Integer> putChair(char[][] gym) {
        int m = gym.length;
        int n = gym[0].length;

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (EQUIPMENT == gym[i][j]) {
                    if (!addCost(cost, gym, i, j)) {
                        return null;
                    }
                }
            }
        }

        List<Integer> res = Arrays.asList(-1, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (EQUIPMENT != gym[i][j] && OBSTACLE != gym[i][j]) {
                    if ((res.get(0) == -1 && res.get(1) == -1) || (cost[i][j] < cost[res.get(0)][res.get(1)])) {
                        res.set(0, i);
                        res.set(1, j);
                    }
                }
            }
        }
        return res;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                Pair curr = queue.poll();
                List<Pair> neighbors = getNeighbors(curr, gym);
                for (Pair neighbor : neighbors) {
                    if (!visited[neighbor.i][neighbor.j]) {
                        visited[neighbor.i][neighbor.j] = true;
                        cost[neighbor.i][neighbor.j] += pathCost;
                        queue.offer(neighbor);
                    }
                }
            }
            pathCost++;
        }

        for (int l = 0; l < gym.length; l++) {
            for (int m = 0; m < gym[0].length; m++) {
                if (!visited[l][m] && EQUIPMENT == gym[l][m]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNeighbors(Pair curr, char[][] gym) {
        int x = curr.i;
        int y = curr.j;
        int m = gym.length;
        int n = gym[0].length;
        List<Pair> neighbors = new ArrayList<>();
        if (x + 1 < m && OBSTACLE != gym[x + 1][y]) {
            neighbors.add(new Pair(x + 1, y));
        }
        if (y + 1 < n && OBSTACLE != gym[x][y + 1]) {
            neighbors.add(new Pair(x, y + 1));
        }

        if (x - 1 >= 0 && OBSTACLE != gym[x - 1][y]) {
            neighbors.add(new Pair(x - 1, y));
        }
        if (y - 1 >= 0 && OBSTACLE != gym[x][y - 1]) {
            neighbors.add(new Pair(x, y - 1));
        }
        return neighbors;
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
