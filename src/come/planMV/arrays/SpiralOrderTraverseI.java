package come.planMV.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        dfsTraverse(matrix, 0, matrix.length, res);
        return res;
    }

    private void dfsTraverse(int[][] matrix, int offset, int len, List<Integer> res) {
        if (len == 1) {
            res.add(matrix[offset][offset]);
            return;
        }

        if (len == 0) {
            return;
        }

        for (int i = 0; i < len - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < len - 1; i++) {
            res.add(matrix[offset + i][offset + len - 1]);
        }
        for (int i = len - 1; i > 0; i--) {
            res.add(matrix[offset + len - 1][offset + i]);
        }
        for (int i = len - 1; i > 0; i--) {
            res.add(matrix[i + offset][offset]);
        }
        dfsTraverse(matrix, offset + 1, len - 2, res);
    }
}
