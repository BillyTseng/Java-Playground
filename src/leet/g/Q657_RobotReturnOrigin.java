package leet.g;

public class Q657_RobotReturnOrigin {
    private enum Directions {
        UP (0, 1), DOWN (0, -1), LEFT (-1, 0), RIGHT (1, 0);

        private final int x;
        private final int y;
        Directions(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Cord {
        int x;
        int y;
        Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        Cord point = new Cord(0, 0);
        for (char c : moves.toCharArray()) {
            char dir = Character.toUpperCase(c);
            if (dir == 'U') {
                applyMove(point, Directions.UP);
            } else if (dir == 'D') {
                applyMove(point, Directions.DOWN);
            } else if (dir == 'L') {
                applyMove(point, Directions.LEFT);
            } else if (dir == 'R') {
                applyMove(point, Directions.RIGHT);
            }
        }

        return point.x == 0 && point.y == 0;
    }

    private void applyMove(Cord point, Directions dir) {
        point.x += dir.x;
        point.y += dir.y;
    }
}
