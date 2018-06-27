package come.class24_twoPointer_LCA.attempt01;

import java.util.Arrays;

public class Q3_2_RotateMatrix {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length);
    }

    private void rotate (int[][] matrix, int offset, int size) {
        if (size <= 1) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
            matrix[offset + i][offset + size - 1] = temp;
        }
        rotate(matrix, offset + 1, size - 2);
    }

    public static void main(String[] args) {
        Q3_2_RotateMatrix solution = new Q3_2_RotateMatrix();
        int[][] matrix = new int[][] {{1, 2, 3},
                                      {8, 9, 4},
                                      {7, 6, 5}};

        solution.rotate(matrix);
        for (int[] item : matrix) {
            System.out.println(Arrays.toString(item));
        }
    }
}
