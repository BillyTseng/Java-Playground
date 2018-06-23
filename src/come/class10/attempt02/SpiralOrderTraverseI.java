package come.class10.attempt02;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) {
            return res;
        }

        spiral(matrix, res, 0, n);
        return res;
    }

    private void spiral(int[][] matrix, List<Integer> res, int offset, int size) {
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

        spiral(matrix, res, offset + 1, size - 2);
    }
}
