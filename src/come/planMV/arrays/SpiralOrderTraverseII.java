package come.planMV.arrays;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/spiral-matrix/ medium */

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }

            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y++]);
            }

            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x++][y]);
            }

            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y--]);
            }

            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x--][y]);
            }

            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }
        return res;
    }
}
