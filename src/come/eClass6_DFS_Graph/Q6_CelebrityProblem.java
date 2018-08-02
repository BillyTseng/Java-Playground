package come.eClass6_DFS_Graph;
/**
 * We don't care matrix[i][i]
 * matrix = { { x, 1, 1 },
 *            { 0, x, 0 },
 *            { 1, 1, x } }
 */
public class Q6_CelebrityProblem {
    public int celebrity(int[][] matrix) {
        // check all zero case.
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cnt += matrix[i][j];
                if (cnt > 1) {
                    break;
                }
            }
        }
        if (cnt == 0) {
            return -1;
        }

        // start checking from row 0;
        int row = 0;
        for (int col = 1; col < matrix.length; col++) {
            if (matrix[row][col] == 1) {
                row = col;
            }
        }

        // make sure the row candidate is not know others.
        for (int i = 0; i < row; i++) {
            if (matrix[row][0] == 1) {
                return -1;
            }
        }
        return row;
    }
}
