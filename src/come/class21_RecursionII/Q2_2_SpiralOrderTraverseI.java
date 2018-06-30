package come.class21_RecursionII;

import java.util.ArrayList;
import java.util.List;

public class Q2_2_SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiral(matrix, 0, matrix.length, res);
        return res;
    }

    private void spiral(int[][] matrix, int offset, int size, List<Integer> res) {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            res.add(matrix[offset][offset]);
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }

        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset + i][offset + size - 1]);
        }

        for (int i = size - 1; i >= 1; i--) {
            res.add(matrix[offset + size - 1][offset + i]);
        }

        for (int i = size - 1; i >= 1; i--) {
            res.add(matrix[offset + i][offset]);
        }
        spiral(matrix, offset + 1, size - 2, res);
    }
}
