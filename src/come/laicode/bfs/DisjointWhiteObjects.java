package come.laicode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DisjointWhiteObjects {
    private final int WHITE = 0;
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int whiteObjects(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int numberOfWhite = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == WHITE && !visited[i][j]) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        List<Pair> neighbors = getNeighbors(cur, matrix, visited);
                        for (Pair neighbor : neighbors) {
                            queue.offer(neighbor);
                            visited[neighbor.x][neighbor.y] = true;
                        }
                    }
                    numberOfWhite++;
                }
            }
        }
        return numberOfWhite;
    }


    private List<Pair> getNeighbors(Pair cur, int[][] matrix, boolean[][] visited) {
        List<Pair> res = new ArrayList<>();
        Pair node;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            node = new Pair(dir.moveX(cur.x), dir.moveY(cur.y));
            if (isValid(node, matrix, visited)) {
                res.add(node);
            }
        }
        return res;
    }

    private boolean isValid(Pair node, int[][] matrix, boolean[][] visited) {
        return node.x >= 0 && node.x < matrix.length && node.y >= 0 && node.y < matrix[0].length &&
                matrix[node.x][node.y] == WHITE && !visited[node.x][node.y];
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x) {
            return x + deltaX;
        }

        public int moveY(int y) {
            return y + deltaY;
        }
    }
}
