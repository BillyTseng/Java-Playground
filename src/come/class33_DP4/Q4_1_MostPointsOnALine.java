package come.class33_DP4;

import java.util.HashMap;
import java.util.Map;

public class Q4_1_MostPointsOnALine {
    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int most(Point[] points) {
        int result = 0;
        for (int i = 0; i< points.length; i++) {
            Point seed = points[i];
            int sameXY = 1;
            int sameX = 0;
            int most = 0;
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y) {
                    sameXY++;
                } else if (tmp.x == seed.x) {
                    sameX++;
                } else {
                    double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                    Integer count = cnt.get(slope);
                    if (count == null) {
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, count + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                }
            }
            most = Math.max(most, sameX) + sameXY;
            result = Math.max(result, most);
        }
        return result;
    }
}
