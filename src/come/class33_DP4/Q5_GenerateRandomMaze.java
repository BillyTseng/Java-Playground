package come.class33_DP4;

public class Q5_GenerateRandomMaze {
    private static final int CORRIDOR = 0;
    private static final int WALL = 1;

    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = CORRIDOR;
                } else {
                    maze[i][j] = WALL;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(x, 2);
            int nextY = dir.moveY(y, 2);
            if (isValidWall(maze, nextX, nextY)) {
                maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = CORRIDOR;
                maze[nextX][nextY] = CORRIDOR;
                generate(maze, nextX, nextY);
            }
        }
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int randIdx = i + (int)(Math.random() * (dirs.length - i));
            Dir tmp = dirs[i];
            dirs[i] = dirs[randIdx];
            dirs[randIdx] = tmp;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == WALL;
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }
}
