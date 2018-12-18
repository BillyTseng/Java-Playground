package leet.topics.firms.g;

import java.util.*;

public class Q939_MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            set.add(x * 40001 + y);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (set.contains(points[i][0] * 40001 + points[j][1]) &&
                            set.contains(points[j][0] * 40001 + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
