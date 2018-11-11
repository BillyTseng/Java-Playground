package leet.topics.firms.a.freq;

public class Q59_SpiralMatrixII {
    int count = 1;
    int[][] res;
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        res = new int[n][n];
        spiral(0, n);
        return res;
    }

    private void spiral(int offset, int size) {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            res[offset][offset] = count;
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            res[offset][offset + i] = count++;
        }

        for (int i = 0; i < size - 1; i++) {
            res[offset + i][offset + size - 1] = count++;
        }

        for (int i = size - 1; i > 0; i--) {
            res[offset + size - 1][offset + i] = count++;
        }

        for (int i = size - 1; i > 0; i--) {
            res[offset + i][offset] = count++;
        }
        spiral(offset + 1, size - 2);
    }
}
