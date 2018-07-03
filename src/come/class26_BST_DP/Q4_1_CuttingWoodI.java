package come.class26_BST_DP;

import java.util.Arrays;

/*      L = 10, A = {2, 4, 7}
        index 0 1 2 3  4
        0	  x 0 4 11 20
        1	  x x 0 5  13
        2	  x x x 0  6
        3	  x x x x  0
        4	  x x x x  x

        M[0, 4]
        case 1: M[0][1] + M[1][4] + (A[4] - A[0]) = 23
        case 2: M[0][2] + M[2][4] + 10		      = 20
        case 3: M[0][3] + M[3][4] + 10 		      = 21
*/
public class Q4_1_CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        int[] A = new int[cuts.length + 2];
        A[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            A[i + 1] = cuts[i];
        }
        A[A.length - 1] = length;

        int[][] M = new int[A.length][A.length];
        for (int row = M.length - 2; row >= 0; row--) {
            int initialCol = row + 1;
            for (int col = initialCol; col < M[0].length; col++) {
                if (row - col != -1) {
                    M[row][col] = Integer.MAX_VALUE;
                    for (int k = 1; k <= col - initialCol; k++) {
                        M[row][col] = Math.min(M[row][col], M[row][row + k] + M[row + k][col]);
                    }
                    int baseCost = A[col] - A[row];
                    M[row][col] += baseCost;
                }else {	// row - col == -1 base case
			        M[row][col] = 0;
                }
            }
        }
        return M[0][M.length - 1];
    }
}
